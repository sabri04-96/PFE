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

import com.projetfinetude.pfe.Repository.DepartementRepository;
import com.projetfinetude.pfe.model.Departement;

@RestController
@RequestMapping("/accessmanager")
public class DepartementController {

	@Autowired
	DepartementRepository repo;

	@GetMapping("/Departements")
	public ResponseEntity<List<Departement>> getAllDepartemets() {
		try {
			List<Departement> departements = new ArrayList<Departement>();
			repo.findAll().forEach(departements::add);

			if (departements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(departements, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Departement/{id}")
	public ResponseEntity<Departement> getCategorieById(@PathVariable("id") int id) {
		Optional<Departement> departementData = repo.findById(id);
		if (departementData.isPresent()) {
			return new ResponseEntity<>(departementData.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Departement")
	public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Departement departementtosave = new Departement(departement.getName(), departement.getAdress(),
					departement.getTeams());
			departementtosave.setCreationDate(dtf.format(now));
			departementtosave.setLastUpdatDate(dtf.format(now));
			Departement _Departement = repo.save(departementtosave);

			return new ResponseEntity<>(_Departement, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Departement/{id}")
	public ResponseEntity<Departement> updateDepartement(@PathVariable("id") int id,
			@RequestBody Departement departementPassed) {
		Optional<Departement> departementData = repo.findById(id);
		if (departementData.isPresent()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Departement departement = departementData.get();
			departement.setName(departementPassed.getName());
			departement.setAdress(departementPassed.getAdress());
			departement.setLastUpdatDate(dtf.format(now));
			return new ResponseEntity<>(repo.save(departement), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Departements/{id}")
	public ResponseEntity<HttpStatus> deleteDepartement(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Departements")
	public ResponseEntity<HttpStatus> deleteAllDepartements() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}