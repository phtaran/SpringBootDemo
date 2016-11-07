package com.example.web.resource;

import com.example.domain.Person;
import com.example.repository.PersonRepository;
import com.example.service.OtherPersonService;
import com.example.service.PersonService;
import com.example.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    OtherPersonService otherPersonService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    List<Person> getAllPersons() {

        List<Person> all = personRepository.findAll();
        return all;
    }

    @PostMapping(value = "/model_attribute")
    String getAccount(@ModelAttribute("person") String person) {

        return "good";
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable("personId") Long personId) {

        Person person = personRepository.findOne(personId);
        return Optional.ofNullable(person).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/test_transactions")
    public String testTransactions() {

        String result = "bad";
        try {
//            result = personService.testTransactions();
            result = otherPersonService.handlePerson();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @PostMapping("/add_person")
    public Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }
}
