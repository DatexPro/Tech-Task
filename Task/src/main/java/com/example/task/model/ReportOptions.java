package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportOptions {
    @JsonProperty("dateGranularity")
    private String dateGranularity;

    @JsonProperty("asinGranularity")
    private String asinGranularity;

    public ReportOptions() {
    }

    public ReportOptions(String dateGranularity, String asinGranularity) {
        this.dateGranularity = dateGranularity;
        this.asinGranularity = asinGranularity;
    }

    public String getDateGranularity() {
        return dateGranularity;
    }

    public void setDateGranularity(String dateGranularity) {
        this.dateGranularity = dateGranularity;
    }

    public String getAsinGranularity() {
        return asinGranularity;
    }

    public void setAsinGranularity(String asinGranularity) {
        this.asinGranularity = asinGranularity;
    }
    // геттеры и сеттеры
}
