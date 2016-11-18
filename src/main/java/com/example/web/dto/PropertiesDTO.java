package com.example.web.dto;

import java.io.Serializable;

public class PropertiesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String firstProperty;
    private final String secondProperty;

    public PropertiesDTO(String firstProperty, String secondProperty) {
        this.firstProperty = firstProperty;
        this.secondProperty = secondProperty;
    }

    public String getFirstProperty() {
        return firstProperty;
    }

    public String getSecondProperty() {
        return secondProperty;
    }
}
