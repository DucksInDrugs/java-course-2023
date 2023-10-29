package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Contacts {
    public List<Contact> parseContacts(List<String> contacts, String sortType) {
        if (contacts == null || contacts.isEmpty()) {
            return List.of();
        }
        ArrayList<Contact> sortedContacts = contacts.stream().map(contact -> {
            if (contact == null) {
                throw new NullPointerException();
            }
            if (contact.contains(" ")) {
                String[] contactData = contact.split(" ");
                return new Contact(contactData[0], contactData[1]);
            } else {
                return new Contact(contact, null);
            }
        }).collect(Collectors.toCollection(ArrayList::new));
        if (sortType.equals("ASC")) {
            Collections.sort(sortedContacts);
        } else if (sortType.equals("DESC")) {
            sortedContacts.sort(Collections.reverseOrder());
        }
        return sortedContacts;
    }
}
