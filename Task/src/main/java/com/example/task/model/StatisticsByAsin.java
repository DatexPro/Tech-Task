package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsByAsin {

    @JsonProperty("parentAsin")
    private String parentAsin;

    @JsonProperty("salesByAsin")
    private Sales salesByAsin;

    @JsonProperty("trafficByAsin")
    private Traffic trafficByAsin;

    public StatisticsByAsin() {
    }

    public StatisticsByAsin(String parentAsin) {
        this.parentAsin = parentAsin;
    }

    public StatisticsByAsin(String parentAsin, Sales salesByAsin, Traffic trafficByAsin) {
        this.parentAsin = parentAsin;
        this.salesByAsin = salesByAsin;
        this.trafficByAsin = trafficByAsin;
    }

    public String getParentAsin() {
        return parentAsin;
    }

    public void setParentAsin(String parentAsin) {
        this.parentAsin = parentAsin;
    }

    public Sales getSalesByAsin() {
        return salesByAsin;
    }

    public void setSalesByAsin(Sales salesByAsin) {
        this.salesByAsin = salesByAsin;
    }

    public Traffic getTrafficByAsin() {
        return trafficByAsin;
    }

    public void setTrafficByAsin(Traffic trafficByAsin) {
        this.trafficByAsin = trafficByAsin;
    }
}
