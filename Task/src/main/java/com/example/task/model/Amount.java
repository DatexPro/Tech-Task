package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {
    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currencyCode")
    private String currencyCode;

    public Amount() {
    }

    public Amount(double amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
// геттеры и сеттеры
}
