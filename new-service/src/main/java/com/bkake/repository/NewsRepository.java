package com.bkake.repository;

import com.bkake.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllNewsByAuthorId(Long authorId);
    List<News> findAllNewsByCategoryId(Long categoryId);

}
