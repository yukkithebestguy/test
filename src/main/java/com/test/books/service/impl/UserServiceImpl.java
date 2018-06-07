package com.test.books.service.impl;

import com.test.books.dao.RoleRepository;
import com.test.books.dao.UserRepository;
import com.test.books.model.Role;
import com.test.books.model.User;
import com.test.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private RoleRepository roleRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRep.findByName("ROLE_USER"));
        user.setRoles(roles);
        return userRep.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRep.save(user);
    }

    @Override
    @Transactional
    public User findById(Long id){
        Optional<User> user = userRep.findById(id);
        return user.orElse(null);
    }

    @Override
    @Transactional
    public Iterable<User> findAll() {
        return userRep.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        userRep.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(User user){
        userRep.delete(user);
    }

    @Override
    public User findByName(String userName) {
        return userRep.findByUserName(userName);
    }
}
