package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Contacts;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task5Test {
    @Test
    public void parseContactsReturnsCorrectAnswerWithCorrectInputASCTest() {
        List<Contact> contacts = new Contacts().parseContacts(
            List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"), "ASC");
        assertEquals(contacts, List.of(new Contact("Thomas", "Aquinas"),
            new Contact("Rene", "Descartes"),
            new Contact("David", "Hume"),
            new Contact("John", "Locke")
        ));
    }

    @Test
    public void parseContactsReturnsCorrectAnswerWithCorrectInputDESCTest() {
        List<Contact> contacts = new Contacts().parseContacts(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), "DESC");
        assertEquals(contacts, List.of(new Contact("Carl", "Gauss"),
            new Contact("Leonhard", "Euler"),
            new Contact("Paul", "Erdos"))
        );
    }

    @Test
    public void parseEmptyContactsTest() {
        assertEquals(new Contacts().parseContacts(List.of(), "ASC"), List.of());
    }

    @Test
    public void parseNullContactsTest() {
        assertEquals(new Contacts().parseContacts(null, "ASC"), List.of());
    }
}
