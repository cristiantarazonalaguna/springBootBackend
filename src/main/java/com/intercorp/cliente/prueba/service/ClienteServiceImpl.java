package com.intercorp.cliente.prueba.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.cliente.prueba.dao.ClienteRepository;
import com.intercorp.cliente.prueba.dao.ReporteRepository;
import com.intercorp.cliente.prueba.entity.Cliente;
import com.intercorp.cliente.prueba.entity.ReporteCliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	
	private ClienteRepository ClienteRepository;
	
	@Autowired
	private ReporteRepository reporteCliente;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		
		return ClienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return ClienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		
		Random aleatorio = new Random();

	    Calendar unaFecha = Calendar.getInstance();
	    unaFecha.setTime(cliente.getFechanac());
	    unaFecha.add(Calendar.DAY_OF_YEAR, aleatorio.nextInt(30));
	    unaFecha.add(Calendar.MONTH, aleatorio.nextInt(12));
	    unaFecha.add(Calendar.YEAR, aleatorio.nextInt(50));

		cliente.setFechamuerte(unaFecha.getTime());
		return ClienteRepository.save(cliente);
	}

	@Override
	public List<ReporteCliente> findKPI() {
		// TODO Auto-generated method stub
		return reporteCliente.findAll();
	}

}
