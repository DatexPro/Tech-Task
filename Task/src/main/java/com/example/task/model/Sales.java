package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sales {
    @JsonProperty("orderedProductSales")
    private Amount orderedProductSales;

    @JsonProperty("unitsOrdered")
    private int unitsOrdered;

    public Sales() {
    }

    public Sales(Amount orderedProductSales, int unitsOrdered) {
        this.orderedProductSales = orderedProductSales;
        this.unitsOrdered = unitsOrdered;
    }

    public Amount getOrderedProductSales() {
        return orderedProductSales;
    }

    public void setOrderedProductSales(Amount orderedProductSales) {
        this.orderedProductSales = orderedProductSales;
    }

    public int getUnitsOrdered() {
        return unitsOrdered;
    }

    public void setUnitsOrdered(int unitsOrdered) {
        this.unitsOrdered = unitsOrdered;
    }

}
