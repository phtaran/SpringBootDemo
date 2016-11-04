package com.example.web.resource;

import com.example.domain.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Person> getAllPersons() {

        List<Person> all = personRepository.findAll();
        return all;
    }
}
