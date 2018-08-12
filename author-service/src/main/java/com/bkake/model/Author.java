package com.bkake.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "author_id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
