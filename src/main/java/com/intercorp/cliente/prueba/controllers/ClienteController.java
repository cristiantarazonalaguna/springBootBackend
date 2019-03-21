package com.intercorp.cliente.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.cliente.prueba.entity.Cliente;
import com.intercorp.cliente.prueba.entity.ReporteCliente;
import com.intercorp.cliente.prueba.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins= {"*"})
@RequestMapping("/api")
@Api(tags = {"API de clientes"} )
public class ClienteController {
	
	@Autowired
	private ClienteService clienteServ;
	
	@GetMapping("/listclientes")
	@ApiOperation(
            value = "Lista todos los clientes",
            notes = "Devuelve todos los registros de los clientes"
    )
	public List<Cliente> findAll(){
		return clienteServ.findAll();
	}
	@ApiOperation(
            value = "Muestra los kpis del cliente",
            notes = "Devuelve el promedio y la desviacion estandar"
    )
	@GetMapping("/kpideclientes")
	public List<ReporteCliente> listado(){
		return clienteServ.findKPI();
	}
	
	@ApiOperation(
            value = "Busca un cliente por id",
            notes = "Devuelve el cliente"
    )
	@GetMapping("/cliente/{id}")
	public Cliente finById(@PathVariable Long id) {
		return clienteServ.findById(id);
	}
	
	@ApiOperation(
            value = "Crea un nuevo cliente",
            notes = "Devuelve el cliente creado"
    )
	@PostMapping("/creacliente")
	public Cliente save(@RequestBody Cliente empleados) {
		return clienteServ.save(empleados);
	}
	
	@ApiOperation(
            value = "Actualiza un cliente",
            notes = "Devuelve el cliente actualizado"
    )
	@PutMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
		
		Cliente clientes = clienteServ.findById(id);
		clientes.setNombre(cliente.getNombre());
		clientes.setApellido(cliente.getApellido());
		clientes.setEdad(cliente.getEdad());
		clientes.setFechanac(cliente.getFechanac());
		clientes.setFechamuerte(cliente.getFechamuerte());
		return clienteServ.save(clientes);
		
	}

}
