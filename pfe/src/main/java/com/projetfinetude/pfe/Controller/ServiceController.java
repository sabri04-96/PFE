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

import com.projetfinetude.pfe.Repository.ServiceRepository;
import com.projetfinetude.pfe.model.Service;

@RestController
@RequestMapping("/accessmanager")
public class ServiceController {

	@Autowired
	ServiceRepository repo;

	@GetMapping("/Service")

	public ResponseEntity<List<Service>> getAllServices() {
		try {
			List<Service> services = new ArrayList<Service>();
			repo.findAll().forEach(services::add);

			if (services.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(services, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Service/{id}")
	public ResponseEntity<Service> getServiceById(@PathVariable("id") int id) {
		Optional<Service> serviceData = repo.findById(id);
		if (serviceData.isPresent()) {
			return new ResponseEntity<>(serviceData.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Service")
	public ResponseEntity<Service> createService(@RequestBody Service service) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Service servicetosave = new Service(service.getName(), service.getDescription(), service.getDuration(),
					service.getCategory(), service.getRequest());
			servicetosave.setCreationDate(dtf.format(now));
			servicetosave.setLastUpdatDate(dtf.format(now));
			Service _Service = repo.save(servicetosave);

			return new ResponseEntity<>(_Service, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Service/{id}")
	public ResponseEntity<Service> updateService(@PathVariable("id") int id, @RequestBody Service servicePassed) {
		Optional<Service> serviceData = repo.findById(id);
		if (serviceData.isPresent()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Service service = serviceData.get();
			service.setDescription(servicePassed.getDescription());
			service.setLastUpdatDate(dtf.format(now));
			return new ResponseEntity<>(repo.save(service), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Services/{id}")
	public ResponseEntity<HttpStatus> deleteService(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Services")
	public ResponseEntity<HttpStatus> deleteAllServices() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}