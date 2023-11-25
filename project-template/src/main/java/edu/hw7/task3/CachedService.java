package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CachedService implements PersonDatabase {
    private final Object lock = new Object();
    private final Map<Integer, Person> cache = new HashMap<>();

    @Override
    public void add(Person person) {
        synchronized (lock) {
            cache.put(person.id(), person);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (lock) {
            cache.remove(id);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (lock) {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.name().equals(name))
                .collect(Collectors.toList());
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (lock) {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.address().equals(address))
                .collect(Collectors.toList());
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (lock) {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.phoneNumber().equals(phone))
                .collect(Collectors.toList());
        }
    }
}
