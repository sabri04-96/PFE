package com.projetfinetude.pfe.Dto;

import java.util.Date;

import com.projetfinetude.pfe.Entities.Category;
import com.projetfinetude.pfe.Entities.Request;
import com.projetfinetude.pfe.Entities.Service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServiceDto {
	
	private int id ; 
	
	private String name;

	private String description;

	private Date duration;

	private Category category;

	private Request request;
	
	
	public ServiceDto fromEntity(Service service) {
		if (service == null) {
			return null;
		}
		return ServiceDto.builder().id(service.getId())
				.name(service.getName())
				.description(service.getDescription())
				.duration(service.getDuration())
				.build();

	}

	public Service toEntity(ServiceDto serviceDto) {
		if (serviceDto == null) {
			return null;
		}
		Service service = new Service();
		service.setId(serviceDto.getId());
		service.setName(serviceDto.getName());
		service.setDescription(serviceDto.getDescription());
		service.setDuration(serviceDto.getDuration());
		return service;
	}

}
