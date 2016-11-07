package com.example.domain;

public class Account {
    String name;
    String password;
    String number;

    public Account() {
    }

    public Account(String name, String password, String number) {
        this.name = name;
        this.password = password;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
