package com.bkake.hystrix;

import com.bkake.dto.CategoryDto;
import com.bkake.dto.ImmutableCategoryDto;
import com.bkake.intercomm.CategoryClient;
import org.springframework.stereotype.Component;

@Component
public class CategoryClientFallback implements CategoryClient {
    @Override
    public CategoryDto getCategoryById(Long id) {
        return ImmutableCategoryDto.of("Fallback categoryName", "Fallback categoryDescription");
    }
}
