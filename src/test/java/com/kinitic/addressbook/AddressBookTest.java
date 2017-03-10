package com.kinitic.addressbook;

import org.junit.Test;

import static com.kinitic.addressbook.Gender.FEMALE;
import static com.kinitic.addressbook.Gender.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookTest {

    @Test
    public void shouldCountNumberOfMalesInAddressBook() throws Exception {
        final AddressBook addressBook = new AddressBook("addressbook.csv");
        assertThat(addressBook.numberOf(MALE), is(3L));
    }

    @Test
    public void shouldCountNumberOfFemalesInAddressBook() throws Exception {
        final AddressBook addressBook = new AddressBook("addressbook.csv");
        assertThat(addressBook.numberOf(FEMALE), is(2L));
    }

}