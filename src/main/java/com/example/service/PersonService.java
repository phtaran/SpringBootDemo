package com.example.service;

import com.example.domain.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Inject
    private EntityManager entityManager;

    @Resource
    DataSource dataSource;

//    @Transactional
    public String testTransactions() {


        innerMethod();

        return "good";
    }

    @Transactional
    public String innerMethod() {

        Person person = new Person("name", 0, "content");
        person.setAge(30);
        personRepository.save(person);
        if (true) {
            throw new RuntimeException("a");
        }
        return "good";
    }
}
