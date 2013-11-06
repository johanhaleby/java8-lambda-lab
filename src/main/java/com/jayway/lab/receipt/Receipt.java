package com.jayway.lab.receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        return beers.stream().map(Beer::getPrice).max(Integer::compare).get();
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

    public int sum() {
        return beers.stream().map(Beer::getPrice).reduce(0, Integer::sum);
    }
}
