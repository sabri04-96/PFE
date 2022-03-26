package com.projetfinetude.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetfinetude.pfe.Entities.Departement;
import com.projetfinetude.pfe.Entities.Person;
import com.projetfinetude.pfe.Entities.Team;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamDto {

	private int id;

	private String name;

	private String email;

	private String description;

	@JsonIgnore
	private List<Person> persons;

	private Departement departement;

	public TeamDto fromEntity(Team team) {
		if (team == null) {
			return null;
		}
		return TeamDto.builder().id(team.getId()).name(team.getName()).email(team.getEmail())
				.description(team.getDescription()).build();

	}

	public Team toEntity(TeamDto teamDto) {
		if (teamDto == null) {
			return null;
		}
		Team team = new Team();
		team.setId(teamDto.getId());
		team.setName(teamDto.getName());
		team.setDescription(teamDto.getDescription());
		team.setEmail(teamDto.getEmail());
		return team;
	}

}
