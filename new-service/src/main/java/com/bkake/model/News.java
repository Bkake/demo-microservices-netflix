package com.bkake.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class News {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "news_id", nullable = false, updatable = false)
  private Long id;

  private String title;

  private String detail;

  @Column(name = "author_id" )
  private Long authorId;

  @Column(name = "category_id")
  private Long categoryId;

  public News(String title, String detail, Long authorId, Long categoryId) {
    this.title = title;
    this.detail = detail;
    this.authorId = authorId;
    this.categoryId = categoryId;
  }

  public News(String title, String detail) {
    this.title = title;
    this.detail = detail;
  }
}
