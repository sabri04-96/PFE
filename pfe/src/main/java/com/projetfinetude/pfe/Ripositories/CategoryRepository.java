package com.projetfinetude.pfe.Ripositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinetude.pfe.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}