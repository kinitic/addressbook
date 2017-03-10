package com.kinitic.addressbook;

public class Person {

    private final String name;
    private final Gender gender;
    private final String dateOfBirth;

    public Person(final String name, final String gender, final String dateOfBirth) {
        this.name = name;
        this.gender = Gender.fromString(gender);
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
