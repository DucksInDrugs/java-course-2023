package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final Iterator<T> backwardIterator;

    public BackwardIterator(Collection<T> collection) {
        List<T> collectionList = new ArrayList<>(collection);
        List<T> reversedList = new ArrayList<>();
        for (int i = collection.size() - 1; i >= 0; i--) {
            reversedList.add(collectionList.get(i));
        }
        this.backwardIterator = reversedList.iterator();
    }

    @Override
    public boolean hasNext() {
        return backwardIterator.hasNext();
    }

    @Override
    public T next() {
        return backwardIterator.next();
    }
}
