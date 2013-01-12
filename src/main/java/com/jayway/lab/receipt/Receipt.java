package com.jayway.lab.receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return -1;
    }

    public int findPriceOfMostExpensiveBeer() {
        return -1;
    }

    public String findNameOfMostExpensiveBeer() {
        return "Error error error";
    }

    public List<String> findNamesOfBeersOfType(Type type) {
        return Collections.emptyList();
    }

    public List<String> findUniqueNamesOfBeersOfTypeInOrder(Type type) {
        return Collections.emptyList();
    }

    public boolean hasAnyBeerWithPriceGreaterThanOrEqualTo(int price) {
        return false;
    }

    public int sum() {
        return -1;
    }

    public double averagePrice() {
        return -0.0d;
    }
}
