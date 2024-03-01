package com.example.task.settings;


import com.example.task.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledTask {

    @Autowired
    private StatisticService statisticService;

    /**
     * Statistics update every 5 minutes
     * */
    @Scheduled(fixedRate = 300000)
    public void updateStatistics() throws IOException {
        String filePath = "files/test_report.json";
        statisticService.updateStatisticsFromJsonFile(filePath);
    }
}
