package com.bkake.api;

import com.bkake.dto.NewsDto;
import com.bkake.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class NewApi {
    @Autowired
    private NewsService newsService;

    protected static Logger logger = LoggerFactory.getLogger(NewApi.class.getName());

    @GetMapping(value = "/news")
    public List<NewsDto> findNews() {
        logger.info("New.findNews()");
        List<NewsDto> newsDtos = newsService.findNews();
        logger.info(String.format("New.findNews(): %s", newsDtos.toString()));
        return newsDtos;
    }

    @GetMapping(value = "/news/{id}")
    public NewsDto findNewsById(@PathVariable Long id) {
        logger.info(String.format("New.findNewsById(%s)", id));
        NewsDto newsDto = newsService.findNewsById(id);
        logger.info(String.format("New.findNewsById: %s", newsDto.toString()));
        return newsDto;
    }

}
