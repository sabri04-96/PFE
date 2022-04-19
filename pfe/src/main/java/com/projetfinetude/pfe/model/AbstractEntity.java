package com.projetfinetude.pfe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@MappedSuperclass
@Getter
@Setter
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false,nullable = false)
	private Integer id;

	@CreatedDate
	@Column(name = "creationDate", nullable = false)
	@JsonIgnore
	private String creationDate;

	@LastModifiedDate
	@Column(name = "lastUpdateDate", nullable = false)
	@JsonIgnore
	private String lastUpdatDate;

}
