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
	private ClienteService empleadoServ;
	
	@GetMapping("/listclientes")
	@ApiOperation(
            value = "Lista todos los clientes",
            notes = "Devuelve todos los registros de los clientes"
    )
	public List<Cliente> findAll(){
		return empleadoServ.findAll();
	}
	
	@GetMapping("/kpideclientes")
	public List<ReporteCliente> listado(){
		return empleadoServ.findKPI();
	}
	
	
	@GetMapping("/empleados/{id}")
	public Cliente finById(@PathVariable Long id) {
		return empleadoServ.findById(id);
	}
	
	@PostMapping("/creacliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente empleados) {
		return empleadoServ.save(empleados);
	}
	
	@PutMapping("/empleados/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente empleado,@PathVariable Long id) {
		
		Cliente empleados = empleadoServ.findById(id);
		empleados.setNombre(empleado.getNombre());
		empleados.setApellido(empleado.getApellido());
		empleados.setEdad(empleado.getEdad());
		empleados.setFechanac(empleado.getFechanac());;
		return empleadoServ.save(empleados);
		
	}

}
