package com.projetfinetude.pfe.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@CreatedDate
	@Column(name = "creationDate", nullable = false)
	@JsonIgnore
	private Date creationDate;

	@LastModifiedDate
	@Column(name = "lastUpdateDate", nullable = false)
	@JsonIgnore
	private Date lastUpdatDate;

}
