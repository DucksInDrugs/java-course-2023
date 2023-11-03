package edu.hw3.task6;

import java.util.Comparator;
import java.util.Objects;

public class Stock {
    private final String title;
    private final Double price;

    public Stock(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public static final Comparator<Stock> PRICE_COMPARATOR = Comparator
        .comparingDouble(Stock::getPrice);

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
