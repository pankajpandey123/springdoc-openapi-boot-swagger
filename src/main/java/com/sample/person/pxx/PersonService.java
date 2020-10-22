package com.sample.person.pxx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	List<Person> findAll() {
		return personRepository.findAll();
	}
}