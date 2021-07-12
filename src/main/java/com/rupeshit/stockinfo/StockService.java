package com.rupeshit.stockinfo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class StockService {
    private List<Stock> stocks;

    public StockService() {
        this.stocks = List.of(
                new Stock("HDFC", 230),
                new Stock("Amazon", 3500),
                new Stock("GOOG", 2600)
        );
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
