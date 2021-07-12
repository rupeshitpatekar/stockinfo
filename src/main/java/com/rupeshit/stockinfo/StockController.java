package com.rupeshit.stockinfo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

@Controller("/")
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Get("/{ticker}")
    public Stock getStocks(String ticker){
        return stockService.getStocks()
                .stream()
                .filter(stock -> stock.getTicker().equals(ticker))
                .findFirst()
                .orElse(null);
    }

    @Get
    public Flowable<Stock> getStocks(){
        return Flowable.interval(1,1, TimeUnit.SECONDS)
                .map(index -> stockService.getStocks().get(index.intValue()));
    }
}
