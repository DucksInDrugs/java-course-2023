package edu.hw3.task6;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private final String title;
    private final Double price;

    public Stock(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return Objects.equals(price, stock.price) && Objects.equals(title, stock.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}
