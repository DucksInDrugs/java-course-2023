package edu.hw3.task5;

import java.util.Comparator;
import java.util.Objects;

public class Contact {
    private final String name;
    private final String surname;

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    static final Comparator<Contact> ASC = Comparator
        .comparing(Contact::getSurname)
        .thenComparing(Contact::getName);
    static final Comparator<Contact> DESC = ASC.reversed();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
