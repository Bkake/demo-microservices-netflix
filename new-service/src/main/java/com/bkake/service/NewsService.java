package com.bkake.service;

import com.bkake.dto.ImmutableNewsDto;
import com.bkake.dto.NewsDto;
import com.bkake.intercomm.AuthorClient;
import com.bkake.intercomm.CategoryClient;
import com.bkake.model.News;
import com.bkake.repository.NewsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsService {
    @Autowired
    private NewsRepository repository;

    @Autowired
    private AuthorClient authorClient;

    @Autowired
    private CategoryClient categoryClient;

    @HystrixCommand(fallbackMethod = "findNewsFallback")
    public List<NewsDto> findNews() {
        return repository.findAll().stream()
                .map(n -> ImmutableNewsDto.builder()
                        .id(n.getId())
                        .title(n.getTitle())
                        .detail(n.getDetail())
                        .author(authorClient.getAuthorById(n.getAuthorId()))
                        .category(categoryClient.getCategoryById(n.getCategoryId()))
                        .build()
                ).collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "findNewsByIdFallback")
    public NewsDto findNewsById(Long id) {
        News news  = repository.findOne(id);
        return  ImmutableNewsDto.builder()
                .id(news.getId())
                .title(news.getTitle())
                .detail(news.getDetail())
                .author(authorClient.getAuthorById(news.getAuthorId()))
                .category(categoryClient.getCategoryById(news.getCategoryId()))
                .build();
    }

    public List<NewsDto> findNewsFallback() {
        return Arrays.asList(ImmutableNewsDto.builder()
                .id(0L)
                .title("findNews fallback Title")
                .detail("findNews fallback Description")
                .author(authorClient.getAuthorById(0L))
                .category(categoryClient.getCategoryById(0L))
                .build());
    }


    public NewsDto findNewsByIdFallback(Long id) {
        return  ImmutableNewsDto.builder()
                .id(0L)
                .title("findNewsById fallback Title")
                .detail("findNewsById fallback Description")
                .author(authorClient.getAuthorById(0L))
                .category(categoryClient.getCategoryById(0L))
                .build();
    }

}
