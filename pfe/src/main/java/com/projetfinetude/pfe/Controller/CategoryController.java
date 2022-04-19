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

import com.projetfinetude.pfe.Repository.CategoryRepository;
import com.projetfinetude.pfe.model.Category;

@RestController
@RequestMapping("/accessmanager")
public class CategoryController {

	@Autowired
	CategoryRepository repo;

	@GetMapping("/Categories")

	public ResponseEntity<List<Category>> getAllCategories() {
		try {
			List<Category> categories = new ArrayList<Category>();
			repo.findAll().forEach(categories::add);

			if (categories.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categories, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Category/{id}")
	public ResponseEntity<Category> getCategorieById(@PathVariable("id") int id) {
		Optional<Category> CategoryData = repo.findById(id);
		if (CategoryData.isPresent()) {
			return new ResponseEntity<>(CategoryData.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Category")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Category categorytosave = new Category(category.getName(), category.getDescription(),
					category.getServices());
			categorytosave.setCreationDate(dtf.format(now));
			categorytosave.setLastUpdatDate(dtf.format(now));
			Category _Category = repo.save(categorytosave);

			return new ResponseEntity<>(_Category, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category categoryPassed) {
		Optional<Category> categoryData = repo.findById(id);
		if (categoryData.isPresent()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			Category category = categoryData.get();
			category.setName(categoryPassed.getName());
			category.setDescription(categoryPassed.getDescription());
			category.setLastUpdatDate(dtf.format(now));
			return new ResponseEntity<>(repo.save(category), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Categories/{id}")
	public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Categories")
	public ResponseEntity<HttpStatus> deleteAllCategories() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}