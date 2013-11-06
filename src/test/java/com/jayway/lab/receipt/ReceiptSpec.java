package com.jayway.lab.receipt;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.jayway.lab.receipt.Type.LAGER;
import static org.assertj.core.api.Assertions.assertThat;

public class ReceiptSpec {

    private Receipt receipt;

    @Before public void
    given_user_has_bought_beers() {
        receipt = new Receipt();
    }

    @Test public void
    find_price_of_cheapest_beer() {
        // When
        int priceOfCheapestBeer = receipt.findPriceOfCheapestBeer();

        // Then
        assertThat(priceOfCheapestBeer).isEqualTo(15);
    }

    @Test public void
    find_price_of_most_expensive_beer() {
        // When
        int priceOfMostExpensiveBeer = receipt.findPriceOfMostExpensiveBeer();

        // Then
        assertThat(priceOfMostExpensiveBeer).isEqualTo(22);
    }

    @Test public void
    find_name_of_most_expensive_beer() {
        // When
        String name = receipt.findNameOfMostExpensiveBeer();

        // Then
        assertThat(name).isEqualTo("Guiness");
    }


    @Test public void
    find_names_of_all_lager_beers() {
        // When
        List<String> names = receipt.findNamesOfBeersOfType(LAGER);

        // Then
        assertThat(names).hasSize(40).containsOnly("Heineken", "Carlsberg");
    }

    @Test public void
    find_unique_names_of_lagers_in_order() {
        // When
        List<String> names = receipt.findUniqueNamesOfBeersOfTypeInOrder(LAGER);

        // Then
        assertThat(names).containsExactly("Carlsberg", "Heineken");
    }

    @Test public void
    find_sum_of_all_beers() {
        // When
        int sum = receipt.sum();

        // Then
        assertThat(sum).isEqualTo(1460);
    }
    
    @Test public void 
    receipt_have_at_least_one_beer_that_costs_fifteen_or_more() {
        // When
        boolean hasAnyBeerWithPriceGreaterThanOrEqualToFifteen = receipt.hasAnyBeerWithPriceGreaterThanOrEqualTo(15);
        
        // Then
        assertThat(hasAnyBeerWithPriceGreaterThanOrEqualToFifteen).isTrue();
    }
    
    @Test public void 
    receipt_doesnt_have_any__beer_that_costs_fifty_or_more() {
        // When
        boolean hasAnyBeerWithPriceGreaterThanOrEqualToFifty = receipt.hasAnyBeerWithPriceGreaterThanOrEqualTo(50);
        
        // Then
        assertThat(hasAnyBeerWithPriceGreaterThanOrEqualToFifty).isFalse();
    }
}
