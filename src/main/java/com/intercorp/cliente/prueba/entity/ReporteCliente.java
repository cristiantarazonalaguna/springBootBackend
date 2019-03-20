package com.intercorp.cliente.prueba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kpiclientes")
public class ReporteCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer promedio;
	private Integer desviacion;
	
	public Integer getPromedio() {
		return promedio;
		
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	public Integer getDesviacion() {
		return desviacion;
	}
	public void setDesviacion(int desviacion) {
		this.desviacion = desviacion;
	}
	
	
}
