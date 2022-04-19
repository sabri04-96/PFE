package com.projetfinetude.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.model.Request;

public interface RequestRepository extends JpaRepository<Request,Integer> {

}
