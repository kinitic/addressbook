package com.kinitic.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

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
        final Comparator<Person> byAge =
                (p1, p2) -> p2.getDateOfBirth().compareTo(p1.getDateOfBirth());

        return persons.stream().max(byAge).get().getName();
    }


    public long calculateAgeGap(final String name1, final String name2) {
        final Optional<Person> person1 = persons.stream().filter(person -> person.getName().equals(name1)).findFirst();
        final Optional<Person> person2 = persons.stream().filter(person -> person.getName().equals(name2)).findFirst();

        if (person1.isPresent() && person2.isPresent()) {
            final LocalDate dateOfBirthForName1 = person1.get().getDateOfBirth();
            final LocalDate dateOfBirthForName2 = person2.get().getDateOfBirth();
            return DAYS.between(dateOfBirthForName1, dateOfBirthForName2);
        }  else {
            throw new IllegalArgumentException("Invalid names entered, check if they exist in the address book!");
        }
    }
}
