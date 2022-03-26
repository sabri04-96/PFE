package com.projetfinetude.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetfinetude.pfe.Entities.Person;
import com.projetfinetude.pfe.Entities.UserRole;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private int registrationNumber;

	private UserRole role;

	private CredentialsDto credentials;

	@JsonIgnore
	private List<RequestDto> requests;

	private TeamDto teams;

	public PersonDto fromEntity(Person person) {
		if (person == null) {
			return null;
		}
		return PersonDto.builder().id(person.getId()).firstName(person.getFirstName()).lastName(person.getLastName())
				.email(person.getEmail()).registrationNumber(person.getRegistrationNumber()).role(person.getRole())
				.phoneNumber(person.getPhoneNumber()).build();

	}

	public Person toEntity(PersonDto personDto) {
		if (personDto == null) {
			return null;
		}
		Person person = new Person();
		person.setId(personDto.getId());
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setEmail(personDto.getEmail());
		person.setRegistrationNumber(personDto.getRegistrationNumber());
		person.setPhoneNumber(personDto.getPhoneNumber());
		person.setRole(personDto.getRole());
		return person;
	}

}
