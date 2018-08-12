package com.bkake.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "category_id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "category_name")
  private String name;

  @Column(name = "description")
  private String description;

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
