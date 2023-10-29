package edu.hw3.task5;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private final String name;
    private final String surname;

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        if (this.surname == null && o.surname == null) {
            return this.name.compareTo(o.name);
        } else if (this.surname == null) {
            return this.name.compareTo(o.surname);
        } else if (o.surname == null) {
            return this.surname.compareTo(o.name);
        } else {
            return this.surname.compareTo(o.surname);
        }
    }

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
