package com.intercorp.cliente.prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intercorp.cliente.prueba.entity.Cliente;
import com.intercorp.cliente.prueba.entity.ReporteCliente;


public interface ReporteRepository extends JpaRepository<ReporteCliente, Long> {
	
	//@Query("SELECT r.reporteCliente.name FROM Empleados AS c WHERE e.name = :name")
	//public List<Empleados>getReportes();

}
