package org.example.test.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @Before
    public void setup(){
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_not_prices() {
        //act
        double price = priceCalculator.getTotal();
        //assert
        assertThat(price,is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){
        //arrange
        priceCalculator.addPrice(10.2);
        priceCalculator.addPrice(15.5);
        //act
        double total = priceCalculator.getTotal();
        //assert
        assertThat(total,is(25.7));
    }

    @Test
    public void apply_discount_to_prices() {
        //arrange
        priceCalculator.addPrice(40.0);
        priceCalculator.addPrice(60.0);
        priceCalculator.setDiscount(25.0);
        //act
        double total = priceCalculator.getTotal();
        //assert
        assertThat(total,is(25.0));
    }
}