package com.test.books.rest.authorRest;

import com.test.books.dto.AuthorDto;
import com.test.books.model.Author;
import com.test.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;


    @RequestMapping(value = "/author/info/short/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AuthorDto> getById(@PathVariable(name = "id") Long id) {

        HttpHeaders headers = new HttpHeaders();
        Author author = authorService.findById(id);
        if (author == null) {
            return new ResponseEntity<AuthorDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<AuthorDto>(authorService.converterAuthorToDto(author), headers, HttpStatus.OK);
    }

}