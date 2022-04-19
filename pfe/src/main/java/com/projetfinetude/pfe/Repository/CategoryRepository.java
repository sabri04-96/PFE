package com.projetfinetude.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
