package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketImplementation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task6Test {
    @Test
    void stockMarketMostValuableStockReturnsCorrectAnswerTest() {
        StockMarket stockMarket = new StockMarketImplementation();

        stockMarket.add(new Stock("Wycc220", 10000.));
        stockMarket.add(new Stock("VooDooSh", 20000.));
        stockMarket.add(new Stock("Recrent", 5000.));

        Stock stock = stockMarket.mostValuableStock();

        assertEquals(stock, new Stock("VooDooSh", 20000.));
    }

    @Test
    void stockMarketRemoveWorksCorrectlyTest() {
        StockMarket stockMarket = new StockMarketImplementation();

        stockMarket.add(new Stock("Cake", 12.));
        stockMarket.add(new Stock("UncleBjorn", 10.));

        Stock removedStock = new Stock("Browjey", 13.);
        stockMarket.remove(removedStock);
        Stock stock = stockMarket.mostValuableStock();

        assertEquals(stock, new Stock("Cake", 12.));
    }

    @Test
    void stockMarketAddWorksCorrectlyTest() {
        StockMarket stockMarket = new StockMarketImplementation();

        stockMarket.add(new Stock("Guit88man", 10.));
        Stock stock = stockMarket.mostValuableStock();

        assertEquals(stock, new Stock("Guit88man", 10.));
    }
}
