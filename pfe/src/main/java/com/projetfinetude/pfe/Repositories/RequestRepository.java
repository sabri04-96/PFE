package com.projetfinetude.pfe.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.Entities.Request;

public interface RequestRepository extends JpaRepository<Request,Integer> {

}