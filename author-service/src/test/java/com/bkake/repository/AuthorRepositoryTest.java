package com.bkake.repository;

import com.bkake.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository repository;

    @Test
    public void savesAuthorTest() {
        Author authorExcepted = new Author("Dupond", "Bernard");
        Author authorActual = repository.save(authorExcepted);
        assertThat(authorActual.getFirstName()).isEqualTo(authorExcepted.getFirstName());
        assertThat(authorActual.getLastName()).isEqualTo(authorExcepted.getLastName());
    }

    @Test
    public void FindAllAuthorTest() {
        List<Author> authors = repository.findAll();
        assertThat(authors.isEmpty()).isFalse();
        assertThat(authors.size()).isEqualTo(3);
    }

    @Test
    public void FindAuthorByIdTest() {
       Author author = repository.findOne(1L);
       assertThat(author.getFirstName()).isEqualTo("Kake");
       assertThat(author.getLastName()).isEqualTo("Bangaly");
    }
}
