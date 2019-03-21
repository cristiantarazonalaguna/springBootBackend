package com.intercorp.cliente.prueba.service;

import java.util.List;

import com.intercorp.cliente.prueba.entity.Cliente;
import com.intercorp.cliente.prueba.entity.ReporteCliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public List<ReporteCliente>findKPI();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente empleados);
	

}
