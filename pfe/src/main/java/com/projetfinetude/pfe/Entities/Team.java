package com.projetfinetude.pfe.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "Team")
public class Team extends AbstractEntity {

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String description;

	@OneToMany(mappedBy = "team")
	private List<Person> persons;

	@ManyToOne
	@JoinColumn(name = "departement")
	private Departement departement;

}