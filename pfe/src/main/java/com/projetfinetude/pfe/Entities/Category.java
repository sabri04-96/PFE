package com.projetfinetude.pfe.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Category")
public class Category extends AbstractEntity {

	/**
	 * @param name
	 * @param description
	 * @param services
	 */
	public Category(String name, String description, List<Service> services) {
		super();
		this.name = name;
		this.description = description;
		this.services = services;
	}

	@Column
	private String name;

	@Column
	private String description;

	@OneToMany(mappedBy = "category")
	private List<Service> services;
}
