package com.koo9.myspringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 21L;

	@Id
	@GeneratedValue
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@Column
	@NotBlank(message = "Name in mandatory")
	@JacksonXmlProperty
	private String name;

	@Column
	@NotBlank(message = "Email in mandatory")
	@JacksonXmlProperty
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}