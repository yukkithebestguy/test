package com.test.books.rest;

import com.test.books.model.User;
import com.test.books.security.JwtAuthenticationRequest;
import com.test.books.security.JwtAuthenticationResponse;
import com.test.books.security.JwtTokenUtil;
import com.test.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class AuthenticationRestController {

    @Value("Authorization")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "/app/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                       HttpServletRequest request) throws AuthenticationException {
        Device device = DeviceUtils.getCurrentDevice(request);

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final User user = userService.findByName(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(user, device);

        return ResponseEntity.ok(new JwtAuthenticationResponse(token, user));
    }

}
