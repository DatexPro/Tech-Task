package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Document(collection = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("date")
    private String date;

    @JsonProperty("salesByDate")
    private Sales salesByDate;

    @JsonProperty("trafficByDate")
    private Traffic trafficByDate;


    @JsonProperty("parentAsin")
    private String parentAsin;

    @JsonProperty("salesByAsin")
    private Sales salesByAsin;

    @JsonProperty("trafficByAsin")
    private Traffic trafficByAsin;

    public Statistic() {
    }

    public Statistic(String id, String date, Sales salesByDate, Traffic trafficByDate, String parentAsin, Sales salesByAsin, Traffic trafficByAsin) {
        this.id = id;
        this.date = date;
        this.salesByDate = salesByDate;
        this.trafficByDate = trafficByDate;
        this.parentAsin = parentAsin;
        this.salesByAsin = salesByAsin;
        this.trafficByAsin = trafficByAsin;
    }

    public Statistic getWithDate(String date) {
        this.date = date;
        return this;
    }

    public Statistic getWithAsin(String parentAsin) {
        this.parentAsin = parentAsin;
        return this;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
