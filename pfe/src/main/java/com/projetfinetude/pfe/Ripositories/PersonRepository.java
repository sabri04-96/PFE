package com.projetfinetude.pfe.Ripositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.Entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
