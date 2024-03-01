package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Report {
    @JsonProperty("reportSpecification")
    private ReportSpecification reportSpecification;

    @JsonProperty("salesAndTrafficByDate")
    private List<Statistic> salesAndTrafficByDateList;

    @JsonProperty("salesAndTrafficByAsin")
    private List<Statistic> salesAndTrafficByAsinList;

    public Report() {
    }

    public Report(ReportSpecification reportSpecification, List<Statistic> salesAndTrafficByDateList, List<Statistic> salesAndTrafficByAsinList) {
        this.reportSpecification = reportSpecification;
        this.salesAndTrafficByDateList = salesAndTrafficByDateList;
        this.salesAndTrafficByAsinList = salesAndTrafficByAsinList;
    }

    public ReportSpecification getReportSpecification() {
        return reportSpecification;
    }

    public void setReportSpecification(ReportSpecification reportSpecification) {
        this.reportSpecification = reportSpecification;
    }

    public List<Statistic> getSalesAndTrafficByDateList() {
        return salesAndTrafficByDateList;
    }

    public void setSalesAndTrafficByDateList(List<Statistic> salesAndTrafficByDateList) {
        this.salesAndTrafficByDateList = salesAndTrafficByDateList;
    }

    public List<Statistic> getSalesAndTrafficByAsinList() {
        return salesAndTrafficByAsinList;
    }

    public void setSalesAndTrafficByAsinList(List<Statistic> salesAndTrafficByAsinList) {
        this.salesAndTrafficByAsinList = salesAndTrafficByAsinList;
    }
}

