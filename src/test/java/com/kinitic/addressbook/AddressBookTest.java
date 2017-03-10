package com.kinitic.addressbook;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookTest {

    @Test
    public void shouldCountNumberOfMalesInAddressBook() throws Exception {
        final AddressBook addressBook = new AddressBook("addressbook.csv");
        assertThat(addressBook.numberOfMales(), is(3L));
    }
}