package com.jayway.lab.receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

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
        // For some reason "min()" cannot be used
        return beers.stream().map(Beer::getPrice).reduce(MAX_VALUE, Math::min);
    }

    public int findPriceOfMostExpensiveBeer() {
        // For some reason "max()" cannot be used
        return beers.stream().map(Beer::getPrice).reduce(MIN_VALUE, Math::max);
    }

    public String findNameOfMostExpensiveBeer() {
        return beers.stream().max((beer1, beer2) -> beer1.getPrice() - beer2.getPrice()).orElseThrow(IllegalArgumentException.class).getName();
    }

    public List<String> findNamesOfBeersOfType(Type type) {
        return beers.stream().filter((beer) -> beer.getType() == type).map(Beer::getName).collect(Collectors.<String>toList());
    }

    public List<String> findUniqueNamesOfBeersOfTypeInOrder(Type type) {
        return beers.stream().filter((beer) -> beer.getType() == type).map(Beer::getName).uniqueElements().sorted(String::compareTo).collect(Collectors.<String>toList());
    }

    public int sum() {
        return beers.stream().map(Beer::getPrice).reduce(0, Integer::sum);
    }
}
