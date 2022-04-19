package com.projetfinetude.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findByEmail(String email);
}
