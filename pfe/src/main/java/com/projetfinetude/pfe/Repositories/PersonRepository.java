package com.projetfinetude.pfe.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.Entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findByEmail(String email);
}
