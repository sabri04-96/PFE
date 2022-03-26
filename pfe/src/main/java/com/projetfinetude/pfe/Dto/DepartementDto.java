package com.projetfinetude.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetfinetude.pfe.Entities.Departement;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartementDto {

	private Integer id;

	private String name;

	private String adress;

	@JsonIgnore
	private List<TeamDto> teams;

	public DepartementDto fromEntity(Departement departement) {
		if (departement == null) {
			return null;
		}
		return DepartementDto.builder().id(departement.getId()).adress(departement.getAdress())
				.name(departement.getName()).build();

	}

	public Departement toEntity(DepartementDto departementDto) {
		if (departementDto == null) {
			return null;
		}
		Departement departement = new Departement();
		departement.setId(departementDto.getId());
		departement.setAdress(departementDto.getAdress());
		departement.setName(departementDto.getName());
		return departement;
	}
}
