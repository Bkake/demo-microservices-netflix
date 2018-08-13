package com.bkake.api;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NewApi.class)
@Ignore
public class NewApiTest {

    @Autowired
    MockMvc mockMvc;

   @Test
   public void newsTest() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/news"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").value("I am the future functional entry point"));
   }
}
