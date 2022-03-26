package com.projetfinetude.pfe.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Service")
public class Service extends AbstractEntity {

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Date duration;

	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "request")
	private Request request;

}