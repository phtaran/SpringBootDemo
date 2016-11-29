package com.example.service;

import com.example.domain.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class OtherPersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    public String handlePerson() {

        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

        Person person = new Person("11", 11, "33");
        personRepository.save(person);
        if (returnTrue()) {
            throw new RuntimeException("ds");
        }

        return "adad";
    }

    boolean returnTrue() {
        return true;
    }
}
