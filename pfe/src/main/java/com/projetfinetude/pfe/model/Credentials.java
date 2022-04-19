package com.projetfinetude.pfe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
@Entity
@Getter
@Setter
@Table(name = "Credentials")
public class Credentials extends AbstractEntity {

	@Column
	private String username;

	@Column
	private String password;

	@OneToOne
	private Person person;

}