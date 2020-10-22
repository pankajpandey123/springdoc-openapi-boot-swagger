package com.sample.person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("person")
public class PersonController {
	/*
	 * @RequestMapping(path = "/person", method = RequestMethod.POST) public Person
	 * person(@Valid @RequestBody Person person) { return person; }
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck(@RequestParam(value = "id")String var) {
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
