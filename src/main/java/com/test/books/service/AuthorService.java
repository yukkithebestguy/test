package com.test.books.service;

import com.test.books.dto.AuthorDto;
import com.test.books.model.Author;

public interface AuthorService extends BaseService<Author,Long>  {

    AuthorDto converterAuthorToDto(Author author);
}
