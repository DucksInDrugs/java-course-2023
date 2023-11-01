package edu.hw3.task6;

import java.util.PriorityQueue;
import static edu.hw3.task6.Stock.PRICE_COMPARATOR;

public class StockMarketImplementation implements StockMarket {
    private final PriorityQueue<Stock> stockPriorityQueue = new PriorityQueue<>(PRICE_COMPARATOR);

    @Override
    public void add(Stock stock) {
        stockPriorityQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockPriorityQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockPriorityQueue.peek();
    }
}
