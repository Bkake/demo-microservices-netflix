package com.bkake.repository;

import com.bkake.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class NewsRepositoryTest {
    @Autowired
    NewsRepository repository;

    @Test
    public void saveNewsTest() {
        News newsExcepted = new News("title",  "detail", 1L, 1L);
        News newsActual = repository.save(newsExcepted);
        assertThat(newsActual.getTitle()).isEqualTo(newsExcepted.getTitle());
        assertThat(newsActual.getDetail()).isEqualTo(newsExcepted.getDetail());
        assertThat(newsActual.getAuthorId()).isEqualTo(newsExcepted.getAuthorId());
        assertThat(newsActual.getCategoryId()).isEqualTo(newsExcepted.getCategoryId());
    }


    @Test
    public void findAllNewsTest() {
        List<News> news = repository.findAll();
        assertThat(news.isEmpty()).isFalse();
    }


    @Test
    public void findNewsByIdTest()  {
        News news = repository.findOne(1L);
        assertThat(news).isNotNull();
        assertThat(news.getId()).isEqualTo(1L);
        assertThat(news.getTitle()).isEqualTo("title 1 for test");
        assertThat(news.getDetail()).isEqualTo("detail 1 for test");
        assertThat(news.getAuthorId()).isEqualTo(1L);
        assertThat(news.getCategoryId()).isEqualTo(2L);
    }
}
