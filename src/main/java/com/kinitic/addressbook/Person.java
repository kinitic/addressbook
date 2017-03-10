package com.kinitic.addressbook;

public class Person {

    private final String name;
    private final String gender;
    private final String dateOfBirth;

    public Person(final String name, final String gender, final String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
