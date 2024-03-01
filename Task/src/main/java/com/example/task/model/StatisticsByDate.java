package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsByDate {

    @JsonProperty("date")
    private String date;

    @JsonProperty("salesByDate")
    private Sales salesByDate;

    @JsonProperty("trafficByDate")
    private Traffic trafficByDate;

    public StatisticsByDate() {
    }

    public StatisticsByDate(String date) {
        this.date = date;
    }

    public StatisticsByDate(String date, Sales salesByDate, Traffic trafficByDate) {
        this.date = date;
        this.salesByDate = salesByDate;
        this.trafficByDate = trafficByDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Sales getSalesByDate() {
        return salesByDate;
    }

    public void setSalesByDate(Sales salesByDate) {
        this.salesByDate = salesByDate;
    }

    public Traffic getTrafficByDate() {
        return trafficByDate;
    }

    public void setTrafficByDate(Traffic trafficByDate) {
        this.trafficByDate = trafficByDate;
    }
}
