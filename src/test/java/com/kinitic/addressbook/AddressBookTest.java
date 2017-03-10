package com.kinitic.addressbook;

import org.junit.Before;
import org.junit.Test;

import static com.kinitic.addressbook.Gender.FEMALE;
import static com.kinitic.addressbook.Gender.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookTest {

    private AddressBook addressBook;

    @Before
    public void setup() throws Exception {
       addressBook = new AddressBook("addressbook.csv");
    }
    @Test
    public void shouldCountNumberOfMalesInAddressBook() throws Exception {
        assertThat(addressBook.numberOf(MALE), is(3L));
    }

    @Test
    public void shouldCountNumberOfFemalesInAddressBook() throws Exception {
        assertThat(addressBook.numberOf(FEMALE), is(2L));
    }

    @Test
    public void shouldReturnOldestPersonInAddressBook() throws Exception {
        assertThat(addressBook.findOldest(), is("Wes Jackson"));
    }

    @Test
    public void shouldReturnAgeGapInDays() throws Exception {
        assertThat(addressBook.calculateAgeGap("Bill McKnight", "Paul Robinson"), is(2862L));
    }
}