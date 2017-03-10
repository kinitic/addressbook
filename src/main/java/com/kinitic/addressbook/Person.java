package com.kinitic.addressbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

    private final String name;
    private final Gender gender;
    private final LocalDate dateOfBirth;

    public Person(final String name, final String gender, final String dateOfBirth) {
        this.name = name;
        this.gender = Gender.fromString(gender);
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yy"));
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
