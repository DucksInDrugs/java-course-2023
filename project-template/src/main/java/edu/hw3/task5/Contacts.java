package edu.hw3.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static edu.hw3.task5.Contact.ASC;
import static edu.hw3.task5.Contact.DESC;

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
            sortedContacts.sort(ASC);
        } else if (sortType.equals("DESC")) {
            sortedContacts.sort(DESC);
        }
        return sortedContacts;
    }
}
