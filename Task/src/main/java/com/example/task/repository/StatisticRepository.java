package com.example.task.repository;

import com.example.task.model.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {
    boolean existsByDateAndParentAsin(String date, String asin);
    List<Statistic> findByDate(String date);
    List<Statistic> findByParentAsin(String asin);
}
