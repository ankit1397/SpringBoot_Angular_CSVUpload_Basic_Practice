package com.example.StockPractice.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.StockPractice.helper.CSVHelper;
import com.example.StockPractice.model.StockData;
import com.example.StockPractice.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public void save(MultipartFile file) {
		try {
		      List<StockData> stockDatas = CSVHelper.csvToStockDatas(file.getInputStream());
		      stockRepository.saveAll(stockDatas);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		
	}

}
