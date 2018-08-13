package com.bkake.intercomm;

import com.bkake.dto.CategoryDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("category-service")
public interface CategoryClient {
    @GetMapping(value = "/categories/{id}")
    CategoryDto getCategoryById(@PathVariable("id") Long id);
}
