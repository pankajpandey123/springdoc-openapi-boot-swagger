package com.sample.person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sample.person.backbase.Person;
import com.sample.person.backbase.PersonRepository;
import com.sample.person.backbase.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService pservice;
	
	 
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getall() {		 
			return new ResponseEntity(pservice.findAll(),HttpStatus.OK);
	}

	@PutMapping(value = "/")
	public ResponseEntity<Person> update(@RequestBody Person person) {
		return new ResponseEntity<>(pservice.update(person),HttpStatus.CREATED);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Person> create(@RequestBody Person person) {
		return new ResponseEntity<>(pservice.create(person),HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/")
	public ResponseEntity delete(@RequestParam String id) {
		pservice.delete(Long.parseLong(id));
		return new ResponseEntity(HttpStatus.OK);
	}

}
