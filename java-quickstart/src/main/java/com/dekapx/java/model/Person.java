package com.dekapx.java.model;

import static java.util.Objects.requireNonNull;

public record Person(String firstName, String lastName, String email, String phone) {
    public Person {
        requireNonNull(firstName);
        requireNonNull(lastName);
    }

}
