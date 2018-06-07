package com.test.books.service.impl;

import com.test.books.dao.AuthorRepository;
import com.test.books.model.Author;
import com.test.books.model.Sex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Mock
    private AuthorRepository authorRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Author test = new Author();
        test.setFirstName("TestName");
        test.setLastName("TestLastName");
        test.setSex(Sex.MALE);
        test.setBirthDate(new Date());

        when(authorRepository.save(any(Author.class))).thenReturn(new Author());

        Assert.assertThat(authorService.save(test), is(notNullValue()));

    }

    @Test
    public void update() {
        Author test = new Author();
        test.setFirstName("Name");
        test.setLastName("LastName");
        test.setSex(Sex.MALE);
        test.setBirthDate(new Date());

        when(authorRepository.save(any(Author.class))).thenReturn(new Author());

        Assert.assertThat(authorService.save(test), is(notNullValue()));

        String firstName = "FirstName";
        test.setFirstName(firstName);
        when(authorService.update(test)).thenReturn(test);

        Assert.assertThat(authorService.update(test).getFirstName(), is(firstName));
    }

}