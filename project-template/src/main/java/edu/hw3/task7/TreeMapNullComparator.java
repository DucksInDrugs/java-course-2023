package edu.hw3.task7;

import java.util.Comparator;

public class TreeMapNullComparator<T extends Comparable<? super T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Comparator<T> tComparator = Comparator.nullsFirst(
            Comparator.naturalOrder()
        );
        return tComparator.compare(o1, o2);
    }
}
