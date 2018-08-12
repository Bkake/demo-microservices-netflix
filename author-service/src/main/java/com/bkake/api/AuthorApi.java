package com.bkake.api;

import com.bkake.model.Author;
import com.bkake.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorApi {
    @Autowired
    private AuthorRepository repository;


    @GetMapping(value = "/authors")
    public List<Author> findAllAuthors() {

        return repository.findAll();
    }

    @GetMapping(value = "/authors/{id}")
    public Author findAuthorById(@PathVariable Long id) {
        return repository.findOne(id);
    }
}
