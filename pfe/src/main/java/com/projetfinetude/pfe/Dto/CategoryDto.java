package com.projetfinetude.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetfinetude.pfe.Entities.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

	private Integer id;

	private String name;

	private String description;

	@JsonIgnore
	private List<ServiceDto> services;

	public CategoryDto fromEntity(Category category) {
		if (category == null) {
			return null;
			// throw to exception
		}
		return CategoryDto.builder().id(category.getId()).description(category.getDescription())
				.name(category.getName()).build();

	}

	public Category toEntity(CategoryDto categoryDto) {
		if (categoryDto == null) {
			return null;
			// throw to exception
		}
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());

		return category;
	}

}
