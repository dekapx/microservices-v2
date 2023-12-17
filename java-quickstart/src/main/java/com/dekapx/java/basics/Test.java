package com.dekapx.java.basics;

import com.dekapx.java.model.Person;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(
                "Jack",
                "Ryan",
                "jack.ryan@google.com",
                "+1 1123 456 7890");
        System.out.println(person.firstName() + " " + person.lastName());
    }
}
