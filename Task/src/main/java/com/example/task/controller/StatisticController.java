package com.example.task.controller;

import com.example.task.model.Statistic;
import com.example.task.model.StatisticsByAsin;
import com.example.task.model.StatisticsByDate;
import com.example.task.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public ResponseEntity<List<Statistic>> getAllStatistics() {
        List<Statistic> statistics = statisticService.getAllStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/by-date/{date}")
    public ResponseEntity<List<Statistic>> getStatisticsByDate(@PathVariable String date) {
        List<Statistic> statistics = statisticService.getStatisticsByDate(date);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/by-asin/{asin}")
    public ResponseEntity<List<Statistic>> getStatisticsByAsin(@PathVariable String asin) {
        List<Statistic> statistics = statisticService.getStatisticsByAsin(asin);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/summary-by-date")
    public ResponseEntity<List<Statistic>> getSummaryStatisticsByDate() {
        List<Statistic> statisticsByDate = statisticService.getTotalStatisticsByDate();
        return new ResponseEntity<>(statisticsByDate, HttpStatus.OK);
    }

    @GetMapping("/summary-by-asin")
    public ResponseEntity<List<Statistic>> getSummaryStatisticsByAsin() {
        List<Statistic> statisticsByAsin = statisticService.getTotalStatisticsByAsin();
        return new ResponseEntity<>(statisticsByAsin, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Statistic> saveStatistic(@RequestBody Statistic statistic) {
        Statistic savedStatistic = statisticService.saveStatistic(statistic);
        return new ResponseEntity<>(savedStatistic, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllStatistics() {
        statisticService.deleteAllStatistics();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

