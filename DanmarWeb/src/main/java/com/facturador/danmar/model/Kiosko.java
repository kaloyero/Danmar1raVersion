package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kiosko {


	@Id
	@GeneratedValue
	private int code;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="description")
	private String description;
	
	
	public Kiosko(){
	}

	
	public Kiosko(int code, String nombre, String description) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.description = description;
	}



	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
