package com.test.books.service.impl;

import com.test.books.dao.AuthorRepository;
import com.test.books.dto.AuthorDto;
import com.test.books.model.Author;
import com.test.books.model.Book;
import com.test.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRep;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRep){
        this.authorRep = authorRep;
    }

    @Override
    @Transactional
    public Author save(Author author) {
        return authorRep.save(author);
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return authorRep.save(author);
    }

    @Override
    @Transactional
    public Author findById(Long id){
        Optional<Author> author = authorRep.findById(id);
        return author.orElse(null);
    }

    @Override
    @Transactional
    public Iterable<Author> findAll() {
        return authorRep.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        authorRep.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Author author){
        authorRep.delete(author);
    }

    public AuthorDto converterAuthorToDto(Author author){
        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setId(author.getId());
        authorDto.setAge(getAge(author.getBirthDate()));
        authorDto.setBooks(author.getBooks().stream().map(Book::getTitle).collect(Collectors.toList()));

        return authorDto;
    }

    private Integer getAge(Date birthDate){
        Date now = new Date();
        return  (int)( (now.getTime() - birthDate.getTime())
                / (31536000000L) );
    }
}
