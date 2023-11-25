package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class CachedServiceReadWriteLock implements PersonDatabase {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Person> cache = new HashMap<>();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            cache.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            cache.remove(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.writeLock().lock();
        try {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.name().equals(name))
                .collect(Collectors.toList());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.writeLock().lock();
        try {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.address().equals(address))
                .collect(Collectors.toList());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.writeLock().lock();
        try {
            return cache.values()
                .stream()
                .parallel()
                .filter(person -> person.name() != null
                    && person.address() != null
                    && person.phoneNumber() != null
                    && person.phoneNumber().equals(phone))
                .collect(Collectors.toList());
        } finally {
            lock.writeLock().unlock();
        }
    }
}
