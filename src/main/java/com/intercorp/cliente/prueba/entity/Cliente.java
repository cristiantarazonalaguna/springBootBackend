package com.intercorp.cliente.prueba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@ApiModelProperty(value = "Id del cliente" , position = 1)
	private Long id;
	@Column(name = "nombre")
	//@ApiModelProperty(value = "nombre del cliente" , position = 2)
	private String nombre;
	@Column(name = "apellido")
	//@ApiModelProperty(value = "apellido del cliente" , position = 2)
	private String apellido;
	@Column(name = "edad")
	//@ApiModelProperty(value = "edad del cliente" , position = 2)
	private Integer edad;
	@Column(name = "fechanac")
	@Temporal(TemporalType.DATE)
	private Date fechanac;
	@Column(name = "fechamuerte")
	@Temporal(TemporalType.DATE)
	private Date fechamuerte;

	public Date getFechamuerte() {
		return fechamuerte;
	}

	public void setFechamuerte(Date fechamuerte) {
		this.fechamuerte = fechamuerte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

}
