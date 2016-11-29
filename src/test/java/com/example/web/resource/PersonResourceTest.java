package com.example.web.resource;

import com.example.DemoApplication;
import com.example.domain.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
@Transactional
@WebAppConfiguration
public class PersonResourceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Inject
    private PersonRepository personRepository;

    @Inject PersonService personService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getPersonById() {

        Person person = new Person("John", 20, "test");
        personRepository.saveAndFlush(person);
        System.out.println(personRepository.findAll());

        try {
            this.mockMvc.perform(get("/person/{id}", person.getId()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.name").value("John"))
                    .andExpect(jsonPath("$.age").value(20))
                    .andExpect(jsonPath("$.content").value("test"));
        } catch (Exception e) {
            fail();
        }
    }

}