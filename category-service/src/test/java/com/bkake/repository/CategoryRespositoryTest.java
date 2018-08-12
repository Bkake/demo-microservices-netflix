package com.bkake.repository;

import com.bkake.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import  static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRespositoryTest {

    @Autowired
    CategoryRepository repository;


    @Test
    public void saveCategoryTest() {
        Category categoryExcepted = new Category("People magazine", "Titi wi");
        Category categoryActual = repository.save(categoryExcepted);
        assertThat(categoryActual.getName()).isEqualTo(categoryExcepted.getName());
        assertThat(categoryActual.getDescription()).isEqualTo(categoryExcepted.getDescription());
    }

    @Test
    public void findAllCategoriesTest() {
        List<Category> categories = repository.findAll();
        assertThat(categories.isEmpty()).isFalse();
        assertThat(categories.size()).isEqualTo(3);
    }

    @Test
    public void findCategoryByIdTest() {
      Category category = repository.findOne(2L);
      assertThat(category.getName()).isEqualTo("Foot");
      assertThat(category.getDescription()).isEqualTo("Equipe 21");
    }
}
