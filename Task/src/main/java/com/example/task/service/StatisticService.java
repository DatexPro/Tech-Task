package com.example.task.service;

import com.example.task.model.Statistic;

import java.io.IOException;
import java.util.List;

public interface StatisticService {
    List<Statistic> getAllStatistics();

    List<Statistic> getStatisticsByDate(String date);

    List<Statistic> getStatisticsByAsin(String asin);

    Statistic saveStatistic(Statistic statistic);

    void deleteAllStatistics();

    List<Statistic> getTotalStatisticsByAsin();

    List<Statistic> getTotalStatisticsByDate();

    void updateStatisticsFromJsonFile(String jsonFilePath) throws IOException;
}
