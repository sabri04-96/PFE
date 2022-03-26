package com.projetfinetude.pfe.Dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetfinetude.pfe.Entities.Person;
import com.projetfinetude.pfe.Entities.Request;
import com.projetfinetude.pfe.Entities.Service;
import com.projetfinetude.pfe.Entities.Status;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestDto {

	private int id;

	private String description;

	private int updateId;

	private Date dateRequest;

	private Status status;

	private Person person;

	@JsonIgnore
	private List<Service> services;

	public RequestDto fromEntity(Request request) {
		if (request == null) {
			return null;
		}
		return RequestDto.builder().id(request.getId()).description(request.getDescription())
				.dateRequest(request.getDateRequest()).status(request.getStatus()).updateId(request.getUpdateId())

				.build();

	}

	public Request toEntity(RequestDto requestDto) {
		if (requestDto == null) {
			return null;
		}
		Request request = new Request();
		request.setId(requestDto.getId());
		request.setDescription(requestDto.getDescription());
		request.setUpdateId(requestDto.getUpdateId());
		request.setDateRequest(requestDto.getDateRequest());
		request.setStatus(requestDto.getStatus());
		return request;
	}

}
