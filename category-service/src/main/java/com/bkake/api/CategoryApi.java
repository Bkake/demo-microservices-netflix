package com.bkake.api;

import com.bkake.model.Category;
import com.bkake.repository.CategoryRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Api(description = "API for operations on categories")
@RestController
public class CategoryApi {
    @Autowired
    private CategoryRepository repository;

    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryApi.class.getName());



    @ApiOperation(value = "Get all categories")
    @GetMapping(value = "/categories")
    @HystrixCommand(fallbackMethod = "findAllCategoryFallback")
    public List<Category> findAllCategory() {
        logger.info("Category.findAll()");
        return repository.findAll();
    }


    @ApiOperation(value = "Get an category by his ID")
    @GetMapping(value = "/categories/{id}")
    @HystrixCommand(fallbackMethod = "findCategoryByIdFallback")
    public Category findCategoryById(@PathVariable Long id) {
        logger.info(String.format("Category.findCategoryById(%s)", id));
        return repository.findOne(id);
    }

    public List<Category> findAllCategoryFallback() {
        return Arrays.asList(getFallBackData.get());
    }

    public Category findCategoryByIdFallback(Long id) {
        return getFallBackData.get();
    }

    private Supplier<Category> getFallBackData = () -> {
        Category categoryFallback = new Category();
        categoryFallback.setId(999L);
        categoryFallback.setName("Category fallback name");
        categoryFallback.setDescription("Category fallback description");
        return categoryFallback;
    };
}
