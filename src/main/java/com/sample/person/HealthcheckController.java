package com.sample.person;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
@RequestMapping("healthcheck")
public class HealthcheckController {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck(@RequestParam(value = "format")String var) {
		if (var.equals("short")) {
			return new ResponseEntity<>("ok",HttpStatus.OK);
		}
		if (var.equals("full")) {
			Date date = new Date();
			String strDateFormat = "hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
			String currentTime = dateFormat.format(date);
			return new ResponseEntity<>(currentTime, HttpStatus.OK);
		} else
			return new ResponseEntity<>("bad request",HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/")
	public ResponseEntity healthcheckPut() {
		return new ResponseEntity<>("method not allowed",HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PostMapping(value = "/")
	public ResponseEntity healthcheckPost() {
		return new ResponseEntity<>("method not allowed",HttpStatus.METHOD_NOT_ALLOWED);
	}

	@DeleteMapping(value = "/")
	public ResponseEntity healthcheckDelete() {
		return new ResponseEntity<>("method not allowed",HttpStatus.METHOD_NOT_ALLOWED);
	}

}