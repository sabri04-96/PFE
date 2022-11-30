package com.projetfinetude.pfe.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetfinetude.pfe.Repository.PersonRepository;
import com.projetfinetude.pfe.constants.GlobalConstants;
import com.projetfinetude.pfe.model.Person;

@RestController
@RequestMapping(GlobalConstants.Globalpath)
public class PersonController {

	@Autowired
	PersonRepository repo;

	@GetMapping("/Persons")
	@RolesAllowed("ADMIN_ROLE")
	public ResponseEntity<List<Person>> getAllPersons() {
		try {
			List<Person> persons = new ArrayList<Person>();
			repo.findAll().forEach(persons::add);

			if (persons.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(persons, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
		Optional<Person> personData = repo.findById(id);
		if (personData.isPresent()) {
			return new ResponseEntity<>(personData.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		Person persontosave = new Person(person.getFirstName(), person.getLastName(), person.getEmail(),
				person.getPhoneNumber(), person.getRegistrationNumber(), person.getCredentials(), person.getRequests(),
				person.getTeam(), person.getRole());
		persontosave.setLastUpdatDate(dtf.format(now));
		persontosave.setCreationDate(dtf.format(now));
		try {
			Person _person = repo.save(persontosave);
			return new ResponseEntity<>(_person, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person personPassed) {
		Optional<Person> personData = repo.findById(id);
		if (personData.isPresent()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Person person = personData.get();
			person.setFirstName(personPassed.getFirstName());
			person.setEmail(personPassed.getEmail());
			person.setRequests(personPassed.getRequests());
			person.setTeam(personPassed.getTeam());
			person.setRole(personPassed.getRole());
			person.setLastName(personPassed.getLastName());
			person.setPhoneNumber(personPassed.getPhoneNumber());
			person.setCredentials(person.getCredentials());
			person.setRegistrationNumber(personPassed.getRegistrationNumber());
			person.setLastUpdatDate(dtf.format(now));
			return new ResponseEntity<>(repo.save(person), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Persons/{id}")
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Persons")
	public ResponseEntity<HttpStatus> deleteAllPersons() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}