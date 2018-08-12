package com.bkake.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AuthorApi.class)
@AutoConfigureDataJpa
public class AuthorApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findAllAuthorsTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]").exists())
                .andExpect(jsonPath("$.[1]").exists())
                .andExpect(jsonPath("$.[2]").exists())
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].firstName").value("Kake"))
                .andExpect(jsonPath("$.[0].lastName").value("Bangaly"))
                .andExpect(jsonPath("$.[1].id").value(2L))
                .andExpect(jsonPath("$.[1].firstName").value("Camara"))
                .andExpect(jsonPath("$.[1].lastName").value("Aboubacar"))
                .andExpect(jsonPath("$.[2].id").value(3L))
                .andExpect(jsonPath("$.[2].firstName").value("Conde"))
                .andExpect(jsonPath("$.[2].lastName").value("Lamaye"));
    }

    @Test
    public void findAuthorById() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("firstName").value("Kake"))
                .andExpect(jsonPath("lastName").value("Bangaly"));
    }
}
