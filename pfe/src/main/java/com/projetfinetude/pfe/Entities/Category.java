package com.projetfinetude.pfe.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Category")
public class Category extends AbstractEntity {

	@Column
	private String name;

	@Column
	private String description;

	@OneToMany(mappedBy = "category")
	private List<Service> services;
}
