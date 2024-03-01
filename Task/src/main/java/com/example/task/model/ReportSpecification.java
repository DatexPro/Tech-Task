package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReportSpecification {
    @JsonProperty("reportType")
    private String reportType;

    @JsonProperty("reportOptions")
    private ReportOptions reportOptions;

    @JsonProperty("dataStartTime")
    private String dataStartTime;

    @JsonProperty("dataEndTime")
    private String dataEndTime;

    @JsonProperty("marketplaceIds")
    private List<String> marketplaceIds;

    public ReportSpecification() {
    }

    public ReportSpecification(String reportType, ReportOptions reportOptions, String dataStartTime, String dataEndTime, List<String> marketplaceIds) {
        this.reportType = reportType;
        this.reportOptions = reportOptions;
        this.dataStartTime = dataStartTime;
        this.dataEndTime = dataEndTime;
        this.marketplaceIds = marketplaceIds;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public ReportOptions getReportOptions() {
        return reportOptions;
    }

    public void setReportOptions(ReportOptions reportOptions) {
        this.reportOptions = reportOptions;
    }

    public String getDataStartTime() {
        return dataStartTime;
    }

    public void setDataStartTime(String dataStartTime) {
        this.dataStartTime = dataStartTime;
    }

    public String getDataEndTime() {
        return dataEndTime;
    }

    public void setDataEndTime(String dataEndTime) {
        this.dataEndTime = dataEndTime;
    }

    public List<String> getMarketplaceIds() {
        return marketplaceIds;
    }

    public void setMarketplaceIds(List<String> marketplaceIds) {
        this.marketplaceIds = marketplaceIds;
    }
    // геттеры и сеттеры
}
