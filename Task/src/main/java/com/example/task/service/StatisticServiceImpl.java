package com.example.task.service;

import com.example.task.model.Report;
import com.example.task.model.Sales;
import com.example.task.model.Statistic;
import com.example.task.repository.StatisticRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    @Cacheable(value = "statisticsCache")
    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    @Override
    @Cacheable(value = "statisticsCache")
    public List<Statistic> getStatisticsByDate(String date) {
        return statisticRepository.findByDate(date);
    }

    @Override
    @Cacheable(value = "statisticsCache")
    public List<Statistic> getStatisticsByAsin(String asin) {
        return statisticRepository.findByParentAsin(asin);
    }

    @Override
    public Statistic saveStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Override
    public void deleteAllStatistics() {
        statisticRepository.deleteAll();
    }

    @Override
    public void updateStatisticsFromJsonFile(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Report report = objectMapper.readValue(new File(jsonFilePath), Report.class);
        List<Statistic> statistics = mergeReportIntoStatistics(report);
        for (Statistic statistic : statistics) {
            if (!statisticRepository.existsByDateAndParentAsin(statistic.getDate(),
                    statistic.getParentAsin())) {
                statisticRepository.save(statistic);

            }
        }
    }

    private List<Statistic> mergeReportIntoStatistics(Report report) {
        List<Statistic> statistics = new ArrayList<>();
        statistics.addAll(report.getSalesAndTrafficByDateList());
        statistics.addAll(report.getSalesAndTrafficByAsinList());
        return statistics;
    }

    @Override
    @Cacheable(value = "statisticsCache")
    public List<Statistic> getTotalStatisticsByDate() {
        List<Statistic> allStatistics = statisticRepository.findAll();
        Map<String, Statistic> totalStatisticsByDate = new HashMap<>();
        for (Statistic statistic : allStatistics) {
            if (statistic.getDate() != null) {
                String date = statistic.getDate();
                totalStatisticsByDate.computeIfAbsent(date, key -> new Statistic().getWithDate(date));
                mergeStatisticsForDate(totalStatisticsByDate.get(date), statistic);
            }
        }
        return new ArrayList<>(totalStatisticsByDate.values());
    }

    @Override
    @Cacheable(value = "statisticsCache")
    public List<Statistic> getTotalStatisticsByAsin() {
        List<Statistic> allStatistics = statisticRepository.findAll();
        Map<String, Statistic> totalStatisticsByAsin = new HashMap<>();
        for (Statistic statistic : allStatistics) {
            if (statistic.getParentAsin() != null) {
                String asin = statistic.getParentAsin();
                totalStatisticsByAsin.computeIfAbsent(asin, key -> new Statistic().getWithAsin(asin));
                mergeStatisticsForAsin(totalStatisticsByAsin.get(asin), statistic);
            }
        }
        return new ArrayList<>(totalStatisticsByAsin.values());
    }

    private void mergeStatisticsForDate(Statistic totalStatistic, Statistic statisticsByDate) {
        Sales totalSales = totalStatistic.getSalesByDate();
        Sales newSales = statisticsByDate.getSalesByDate();
        if (totalSales != null && newSales != null) {
            totalSales.getOrderedProductSales().setAmount(totalSales.getOrderedProductSales().getAmount() + newSales.getOrderedProductSales().getAmount());
            totalSales.setUnitsOrdered(totalSales.getUnitsOrdered() + newSales.getUnitsOrdered());
            totalStatistic.setSalesByDate(totalSales);
        } else {
            totalStatistic.setSalesByAsin(newSales);
        }
    }

    private void mergeStatisticsForAsin(Statistic totalStatistic, Statistic statisticsByAsin) {
        Sales totalSales = totalStatistic.getSalesByAsin();
        Sales newSales = statisticsByAsin.getSalesByAsin();
        if (totalSales != null && newSales != null) {
            totalSales.getOrderedProductSales().setAmount(totalSales.getOrderedProductSales().getAmount() + newSales.getOrderedProductSales().getAmount());
            totalSales.setUnitsOrdered(totalSales.getUnitsOrdered() + newSales.getUnitsOrdered());
            totalStatistic.setSalesByAsin(totalSales);
        } else {
            totalStatistic.setSalesByAsin(newSales);
        }
    }

}
