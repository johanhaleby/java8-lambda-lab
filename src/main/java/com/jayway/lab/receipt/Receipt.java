package com.jayway.lab.receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingInt;

public class Receipt {

    private List<Beer> beers = new ArrayList<Beer>() {{
        for (int i = 0; i < 20; i++) {
            add(new Guinness());
        }
        for (int i = 0; i < 20; i++) {
            add(new Heineken());
        }
        for (int i = 0; i < 20; i++) {
            add(new Carlsberg());
        }
        for (int i = 0; i < 20; i++) {
            add(new BishopsFinger());
        }
        Collections.shuffle(this);
    }};

    public int findPriceOfCheapestBeer() {
        return beers.stream().map(Beer::getPrice).min(Integer::compare).get();
    }

    public int findPriceOfMostExpensiveBeer() {
        return beers.stream().mapToInt(Beer::getPrice).max().getAsInt();
    }

    public String findNameOfMostExpensiveBeer() {
        return beers.stream().max((beer1, beer2) -> beer1.getPrice() - beer2.getPrice()).orElseThrow(IllegalStateException::new).getName();
    }

    public List<String> findNamesOfBeersOfType(Type type) {
        return beers.stream().filter((beer) -> beer.getType() == type).map(Beer::getName).collect(Collectors.<String>toList());
    }

    public List<String> findUniqueNamesOfBeersOfTypeInOrder(Type type) {
        return beers.stream().filter((beer) -> beer.getType() == type).map(Beer::getName).distinct().sorted(String::compareTo).collect(Collectors.<String>toList());
    }

    public boolean hasAnyBeerWithPriceGreaterThanOrEqualTo(int price) {
        return beers.stream().map(Beer::getPrice).anyMatch(currentPrice -> currentPrice >= price);
    }

    public int sum() {
        // Alternative to beers.stream().map(Beer::getPrice).reduce(0, Integer::sum);
        return beers.stream().mapToInt(Beer::getPrice).sum();
    }

    public double averagePrice() {
        return beers.stream().collect(summarizingInt(Beer::getPrice)).getAverage();
    }
}
