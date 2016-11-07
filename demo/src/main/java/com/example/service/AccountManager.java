package com.example.service;

import com.example.domain.Account;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AccountManager {

    List<Account> accounts = new ArrayList<>();

    @PostConstruct
    public void init() {
        accounts = IntStream.of(1, 2, 3).mapToObj(String::valueOf).map(this::makeAccount).collect(Collectors.toList());
    }

    private Account makeAccount(String number) {
        Supplier<String> randomString = () -> RandomStringUtils.randomAlphanumeric(5);
        return new Account(randomString.get(), randomString.get(), number);
    }

    public Account findAccount(String number) {
        return accounts.stream().filter(account -> account.getNumber().equals(number)).findFirst().orElseGet(null);
    }
}
