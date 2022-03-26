package com.projetfinetude.pfe.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Entity
@Getter
@Setter
@Table(name = "person")
public class Person extends AbstractEntity {
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String phoneNumber;
	@Column
	private int registrationNumber;

	@OneToOne(mappedBy = "person")
	private Credentials credentials;

	@OneToMany(mappedBy = "person")
	private List<Request> requests;

	@ManyToOne
	@JoinColumn(name = "team")
	private Team team;

	@Column
	private UserRole role;

}
