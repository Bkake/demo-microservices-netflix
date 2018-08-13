package com.bkake.intercomm;

import com.bkake.dto.AuthorDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("author-service")
public interface AuthorClient {
    @GetMapping(value = "/authors/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id);
}
