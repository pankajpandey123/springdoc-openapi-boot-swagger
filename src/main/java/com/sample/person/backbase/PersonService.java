package com.sample.person.backbase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person find(Long id) {
		return personRepository.findById(id).get();
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person create(Person entity) {
		return personRepository.save(entity);
	}

	public Person update(Person entity) {
		return personRepository.save(entity);
	}

	public void delete(Person entity) {
		personRepository.delete(entity);
	}
}