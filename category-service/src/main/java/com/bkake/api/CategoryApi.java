package com.bkake.api;

import com.bkake.model.Category;
import com.bkake.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApi {
    @Autowired
    private CategoryRepository repository;


    @GetMapping(value = "/categories")
    public List<Category> findAllCategories() {
        return repository.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return repository.findOne(id);
    }
}
