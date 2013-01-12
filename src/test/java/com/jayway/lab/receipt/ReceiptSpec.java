package com.jayway.lab.receipt;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.jayway.lab.receipt.Type.LAGER;
import static org.fest.assertions.Assertions.assertThat;

public class ReceiptSpec {

    private Receipt receipt;

    @Before public void
    given_user_has_bought_beers() {
        receipt = new Receipt();
    }

    @Test public void
    find_price_of_cheapest_beer() {
        // When
        final int priceOfCheapestBeer = receipt.findPriceOfCheapestBeer();

        // Then
        assertThat(priceOfCheapestBeer).isEqualTo(15);
    }

    @Test public void
    find_price_of_most_expensive_beer() {
        // When
        final int priceOfMostExpensiveBeer = receipt.findPriceOfMostExpensiveBeer();

        // Then
        assertThat(priceOfMostExpensiveBeer).isEqualTo(22);
    }

    @Test public void
    find_name_of_most_expensive_beer() {
        // When
        final String name = receipt.findNameOfMostExpensiveBeer();

        // Then
        assertThat(name).isEqualTo("Guiness");
    }


    @Test public void
    find_names_of_all_lager_beers() {
        // When
        final List<String> names = receipt.findNamesOfBeersOfType(LAGER);

        // Then
        assertThat(names).hasSize(40).containsOnly("Heineken", "Carlsberg");
    }

    @Test public void
    find_unique_names_of_lagers_in_order() {
        // When
        final List<String> names = receipt.findUniqueNamesOfBeersOfTypeInOrder(LAGER);

        // Then
        assertThat(names).containsExactly("Carlsberg", "Heineken");
    }

    @Test public void
    find_sum_of_all_beers() {
        // When
        final int sum = receipt.sum();

        // Then
        assertThat(sum).isEqualTo(1460);
    }
}
