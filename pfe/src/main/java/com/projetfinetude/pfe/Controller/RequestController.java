package com.projetfinetude.pfe.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetfinetude.pfe.Repository.RequestRepository;
import com.projetfinetude.pfe.model.Request;
import com.projetfinetude.pfe.model.Status;

@RestController
@RequestMapping("/accessmanager")
public class RequestController {

	@Autowired
	RequestRepository repo;

	@GetMapping("/Request")

	public ResponseEntity<List<Request>> getAllRequests() {
		try {
			List<Request> requests = new ArrayList<Request>();
			repo.findAll().forEach(requests::add);

			if (requests.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(requests, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Request/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable("id") int id) {
		Optional<Request> requestData = repo.findById(id);
		if (requestData.isPresent()) {
			return new ResponseEntity<>(requestData.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Request")
	public ResponseEntity<Request> createRequest(@RequestBody Request request) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Request requesttosave = new Request(request.getDescription(), 1, request.getDateRequest(), Status.NEW,
					request.getPerson(), request.getServices());
			requesttosave.setCreationDate(dtf.format(now));
			requesttosave.setLastUpdatDate(dtf.format(now));
			Request _Request = repo.save(requesttosave);

			return new ResponseEntity<>(_Request, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Request/{id}")
	public ResponseEntity<Request> updateRequest(@PathVariable("id") int id, @RequestBody Request requestPassed) {
		Optional<Request> requestData = repo.findById(id);
		if (requestData.isPresent()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Request request = requestData.get();
			request.setDescription(requestPassed.getDescription());
			request.setLastUpdatDate(dtf.format(now));
			return new ResponseEntity<>(repo.save(request), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Requests/{id}")
	public ResponseEntity<HttpStatus> deleteRequst(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Requests")
	public ResponseEntity<HttpStatus> deleteAllRequests() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}