package com.kinitic.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {

    private static final String DELIMITER = ", ";

    private final List<Person> persons;

    public AddressBook(final String filename) throws IOException {
        final Path path = Paths.get("src/main/resources/" + filename);
        final Stream<String> lines = Files.lines(path);

        final Function<String, Person> mapToPerson = (line) -> {
            String[] p = line.split(DELIMITER);
            return new Person(p[0], p[1], p[2]);
        };

        this.persons = lines
                .map(mapToPerson)
                .collect(Collectors.toList());
    }

    public long numberOf(final Gender gender) {
        return persons.stream().filter(person -> person.getGender().equals(gender)).count();
    }

    public String findOldest() {
        throw new UnsupportedOperationException();
    }
}
