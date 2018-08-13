package com.bkake.api;

import com.bkake.dto.AuthorDto;
import com.bkake.dto.CategoryDto;
import com.bkake.dto.ImmutableNewsDto;
import com.bkake.dto.NewsDto;
import com.bkake.intercomm.AuthorClient;
import com.bkake.intercomm.CategoryClient;
import com.bkake.model.News;
import com.bkake.repository.NewsRepository;
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

    @GetMapping(value = "/news{id}")
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

    @GetMapping(value = "/news/author/{authorId}")
    public List<NewsDto> findNewsByAuthorId(@PathVariable Long authorId) {
        return repository.findAllNewsByAuthorId(authorId).stream()
                .map(n -> ImmutableNewsDto.builder()
                        .id(n.getId())
                        .title(n.getTitle())
                        .detail(n.getDetail())
                        .author(authorClient.getAuthorById(n.getAuthorId()))
                        .build()
                ).collect(Collectors.toList());

    }

    @GetMapping(value = "/news/category/{categoryId}")
    public List<NewsDto> findNewsByCategoryId(@PathVariable Long categoryId) {
        return repository.findAllNewsByCategoryId(categoryId).stream()
                .map(n -> ImmutableNewsDto.builder()
                        .id(n.getId())
                        .title(n.getTitle())
                        .detail(n.getDetail())
                        .author(authorClient.getAuthorById(n.getAuthorId()))
                        .build()
                ).collect(Collectors.toList());
    }


}
