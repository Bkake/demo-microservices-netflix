package com.bkake.api;

import com.bkake.dto.ImmutableNewsDto;
import com.bkake.dto.NewsDto;
import com.bkake.intercomm.AuthorClient;
import com.bkake.intercomm.CategoryClient;
import com.bkake.model.News;
import com.bkake.repository.NewsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NewApi {
    @Autowired
    private NewsRepository repository;

    @Autowired
    private AuthorClient authorClient;

    @Autowired
    private CategoryClient categoryClient;


    @GetMapping(value = "/news")
    @HystrixCommand
    public List<NewsDto> findNews() {
        return repository.findAll().stream()
                .map(n -> ImmutableNewsDto.builder()
                            .id(n.getId())
                            .title(n.getTitle())
                            .detail(n.getDetail())
                            .build()
                ).collect(Collectors.toList());
    }

    @GetMapping(value = "/news/{id}")
    @HystrixCommand
    public NewsDto findNewsById(@PathVariable Long id) {
        News news  = repository.findOne(id);
        return  ImmutableNewsDto.builder()
                    .id(news.getId())
                    .title(news.getTitle())
                    .detail(news.getDetail())
                    .author(authorClient.getAuthorById(news.getAuthorId()))
                    .category(categoryClient.getCategoryById(news.getCategoryId()))
                    .build();
    }

}
