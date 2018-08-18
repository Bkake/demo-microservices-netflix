package com.bkake.intercomm;

import com.bkake.dto.CategoryDto;
import com.bkake.hystrix.CategoryClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "category-service", fallback = CategoryClientFallback.class)
public interface CategoryClient {
    @GetMapping(value = "/categories/{id}")
    CategoryDto getCategoryById(@PathVariable("id") Long id);
}
