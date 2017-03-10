package com.kinitic.addressbook;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String name;

    Gender(final String name) {
        this.name = name;
    }

    public static Gender fromString(String gender) {
        for (Gender g : Gender.values()) {
            if (g.name.equalsIgnoreCase(gender)) {
                return g;
            }
        }
        return null;
    }
}
