package com.kinitic.addressbook;

import org.junit.Before;
import org.junit.Test;

import static com.kinitic.addressbook.Gender.FEMALE;
import static com.kinitic.addressbook.Gender.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookTest {

    private static final String ADDRESS_BOOK = "addressbook.csv";

    private AddressBook addressBook;

    @Before
    public void setup() throws Exception {
       addressBook = new AddressBook(ADDRESS_BOOK);
    }
    @Test
    public void shouldCountNumberOfMalesInAddressBook() throws Exception {
        assertThat(addressBook.numberOfPersonsByGender(MALE), is(3L));
    }

    @Test
    public void shouldCountNumberOfFemalesInAddressBook() throws Exception {
        assertThat(addressBook.numberOfPersonsByGender(FEMALE), is(2L));
    }

    @Test
    public void shouldReturnOldestPersonInAddressBook() throws Exception {
        assertThat(addressBook.findOldest(), is("Wes Jackson"));
    }

    @Test
    public void shouldReturnAgeGapInDays() throws Exception {
        assertThat(addressBook.calculateAgeGap("Bill McKnight", "Paul Robinson"), is(2862L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfPersonDoesNotExistInAddressBook() throws Exception {
        addressBook.calculateAgeGap("Bill McKnight", "Bill Nobody");
    }
}