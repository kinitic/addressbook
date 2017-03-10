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

    public long numberOfMales() throws IOException {
        final Path path = Paths.get("src/main/resources/addressbook.csv");
        final Stream<String> lines = Files.lines(path);

        final Function<String, Person> mapToPerson = (line) -> {
            String[] p = line.split(", ");
            return new Person(p[0], p[1], p[2]);
        };

        final List<Person> allPersons = lines
                .map(mapToPerson)
                .collect(Collectors.toList());

        return allPersons.stream().filter(person -> person.getGender().equals("Male")).count();
    }
}
