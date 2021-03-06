package com.example.StockPractice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private Date timestamp;
	private String status;
	private String message;
	private String details;

	public ErrorResponse(Date timestamp, String status, String message, String details) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
	}
}
