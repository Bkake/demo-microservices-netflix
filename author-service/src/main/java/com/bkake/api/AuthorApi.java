package com.bkake.api;

import com.bkake.model.Author;
import com.bkake.repository.AuthorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorApi {
    @Autowired
    private AuthorRepository repository;

    protected static Logger logger = LoggerFactory.getLogger(AuthorApi.class.getName());

    @GetMapping(value = "/authors")
    @HystrixCommand
    public List<Author> findAllAuthors() {
        logger.info("Author.findAllAuthors()");
        List<Author> authors = repository.findAll();
        logger.info(String.format("Author.findAllAuthors: %s", authors));
        return authors;
    }

    @GetMapping(value = "/authors/{id}")
    @HystrixCommand
    public Author findAuthorById(@PathVariable Long id) {
        logger.info(String.format("Author.findAuthorById(%s)", id));
        Author author = repository.findOne(id);
        logger.info(String.format("Author.findAuthorById: %s", author));
        return repository.findOne(id);
    }
}