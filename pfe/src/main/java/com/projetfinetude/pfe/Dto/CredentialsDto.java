package com.projetfinetude.pfe.Dto;

import com.projetfinetude.pfe.Entities.Credentials;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialsDto {

	private Integer id;

	private String username;

	private String password;



	private PersonDto person;

	public CredentialsDto fromEntity(Credentials credentials) {
		if (credentials == null) {
			return null;
		}
		return CredentialsDto.builder().id(credentials.getId()).password(credentials.getPassword())
				.username(credentials.getUsername()).build();

	}

	public Credentials toEntity(CredentialsDto credentialsDto) {
		if (credentialsDto == null) {
			return null;
		}
		Credentials credentials = new Credentials();
		credentials.setId(credentialsDto.getId());
		credentials.setPassword(credentialsDto.getPassword());
		credentials.setUsername(credentialsDto.getUsername());
		return credentials;
	}

}