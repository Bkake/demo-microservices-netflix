package com.bkake.api;

import com.bkake.model.Category;
import com.bkake.repository.CategoryRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApi {
    @Autowired
    private CategoryRepository repository;

    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryApi.class.getName());



    @GetMapping(value = "/categories")
    @HystrixCommand
    public List<Category> findAll() {
        logger.info("Category.findAll()");
        return repository.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    @HystrixCommand
    public Category findCategoryById(@PathVariable Long id) {
        logger.info(String.format("Category.findCategoryById(%s)", id));
        return repository.findOne(id);
    }
}
