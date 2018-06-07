package com.test.books.rest.authorRest;

import com.test.books.model.Author;
import com.test.books.model.Sex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;


import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorRestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private AuthorRestController authorRestController;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(authorRestController).build();
    }

    @Test
    @Transactional
    public void getById() throws Exception {

        mockMvc.perform(get("/author/info/short/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Leonid")))
                .andExpect(jsonPath("$.lastName", is("Dubravsky")));
    }

}