package com.bkake.intercomm;

import com.bkake.dto.AuthorDto;
import com.bkake.hystrix.AuthorClientFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "author-service", fallback = AuthorClientFallback.class)
public interface AuthorClient {
    @GetMapping(value = "/authors/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id);
}
