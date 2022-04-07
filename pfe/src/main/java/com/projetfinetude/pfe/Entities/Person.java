package com.projetfinetude.pfe.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
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
	@JsonIgnore
	private Credentials credentials;

	@OneToMany(mappedBy = "person")
	@JsonIgnore
	private List<Request> requests;

	@ManyToOne
	@JoinColumn(name = "team")
	@JsonIgnore
	private Team team;

	@Column
	private UserRole role;

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param registrationNumber
	 * @param credentials
	 * @param requests
	 * @param team
	 * @param role
	 */
	public Person(String firstName, String lastName, String email, String phoneNumber, int registrationNumber,
			Credentials credentials, List<Request> requests, Team team, UserRole role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationNumber = registrationNumber;
		this.credentials = credentials;
		this.requests = requests;
		this.team = team;
		this.role = role;
	}

}
