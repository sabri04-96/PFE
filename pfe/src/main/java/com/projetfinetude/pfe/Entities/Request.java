package com.projetfinetude.pfe.Entities;

import java.util.Date;
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
@Table(name = "Request")
public class Request extends AbstractEntity {

	@Column
	private String description;

	@Column
	private int updateId;

	@Column
	private Date dateRequest;

	@Column
	private Status status;

	@ManyToOne
	@JoinColumn(name = "person")
	private Person person;

	@OneToMany(mappedBy = "request")
	private List<Service> services;

}