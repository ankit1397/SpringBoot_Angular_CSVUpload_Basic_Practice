package com.example.StockPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StockPractice.model.StockData;

public interface StockRepository extends JpaRepository<StockData, Long> {

}
