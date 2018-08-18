package com.bkake.api;

import com.bkake.dto.NewsDto;
import com.bkake.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewApi {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news")
    public List<NewsDto> findNews() {
        return newsService.findNews();
    }

    @GetMapping(value = "/news/{id}")
    public NewsDto findNewsById(@PathVariable Long id) {
        return newsService.findNewsById(id);
    }

}
