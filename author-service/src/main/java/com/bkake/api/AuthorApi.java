package com.bkake.api;

import com.bkake.model.Author;
import com.bkake.repository.AuthorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Api(description = "API for operations on authors")
@RestController
public class AuthorApi {
    @Autowired
    private AuthorRepository repository;

    protected static Logger logger = LoggerFactory.getLogger(AuthorApi.class.getName());


    @ApiOperation(value = "Get all authors")
    @GetMapping(value = "/authors")
    @HystrixCommand(fallbackMethod = "findAllAuthorsFallback")
    public List<Author> findAllAuthors() {
        logger.info("Author.findAllAuthors()");
        List<Author> authors = repository.findAll();
        logger.info(String.format("Author.findAllAuthors: %s", authors));
        return authors;
    }


    @ApiOperation(value = "Get an author by his ID")
    @GetMapping(value = "/authors/{id}")
    @HystrixCommand(fallbackMethod = "findAuthorByIdFallback")
    public Author findAuthorById(@PathVariable Long id) {
        logger.info(String.format("Author.findAuthorById(%s)", id));
        Author author = repository.findOne(id);
        logger.info(String.format("Author.findAuthorById: %s", author));
        return repository.findOne(id);
    }

    public List<Author> findAllAuthorsFallback() {
        return Arrays.asList(getFallBackData.get());
    }

    public Author findAuthorByIdFallback(Long id) {
        return getFallBackData.get();
    }

    private Supplier<Author> getFallBackData = () -> {
        Author authorFallBack = new Author();
        authorFallBack.setId(999L);
        authorFallBack.setFirstName("Author fallBack FirstName");
        authorFallBack.setLastName("Author fallBack LastName");
        return authorFallBack;
    };
}