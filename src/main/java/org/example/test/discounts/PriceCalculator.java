package org.example.test.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> listPrices;
    private double discount;

    public PriceCalculator() {
        listPrices = new ArrayList<>();
        discount = 0;
    }

    public double getTotal() {
        return listPrices
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum() * ( discount / 100);
    }

    public void addPrice(double price) {
        listPrices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
