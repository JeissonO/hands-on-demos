package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneralExceptionRs {

	private LocalDateTime date;
	private String message;
	private String details;

	public GeneralExceptionRs(LocalDateTime date, String message, String details) {
		this.date = date;
		this.message = message;
		this.details = details;
	}

}
