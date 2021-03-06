package com.example.StockPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.StockPractice.helper.CSVHelper;
import com.example.StockPractice.message.ResponseMessage;
import com.example.StockPractice.service.StockService;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/csv")
public class StockController {

	@Autowired
	private StockService stockService;

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/upload")
	// public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
	public ResponseEntity<ResponseMessage> upload(@RequestBody MultipartFile file) {
		String message = "";
		if (CSVHelper.hasCSVFormat(file)) {
			try {
				stockService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
}
