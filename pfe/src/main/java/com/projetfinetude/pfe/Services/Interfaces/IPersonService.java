package com.projetfinetude.pfe.Services.Interfaces;

import java.util.List;

import com.projetfinetude.pfe.Dto.PersonDto;

public interface IPersonService {

PersonDto save(PersonDto dto);

PersonDto findById(PersonDto dto);

PersonDto findById(Integer id);

PersonDto findByRegistrationNumberDto ();

List<PersonDto> findAll();

void deletePerson(Integer id);

PersonDto updatePerson( );

}
