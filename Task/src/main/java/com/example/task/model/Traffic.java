package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Traffic {
    @JsonProperty("browserPageViews")
    private int browserPageViews;

    public Traffic() {
    }

    public Traffic(int browserPageViews) {
        this.browserPageViews = browserPageViews;
    }

    public int getBrowserPageViews() {
        return browserPageViews;
    }

    public void setBrowserPageViews(int browserPageViews) {
        this.browserPageViews = browserPageViews;
    }
// другие поля и методы доступа
}
