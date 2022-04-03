package com.clemen.mvc.services.impl;

import com.clemen.mvc.entities.Cliente;
import com.clemen.mvc.repositories.ClienteRepository;
import com.clemen.mvc.services.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	/*
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	*/
	
	@Override
	public void guardar(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public List<Cliente> buscarNombreApellido(String nombre, String apellido) {
		return this.clienteRepository.findByNombreAndApellidos(nombre, apellido);
	}

	@Override
	public void borrar(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}


	@Override
	public void crearCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}


	@Override
	public void mostrarTodos() {
		List<Cliente> buscarTodos = buscarTodos();
		
		//Con foreach
		for(Cliente cliente : buscarTodos) {
			logger.debug(cliente.toString());
		}
		
		//Con streams mucho mas potente
		buscarTodos.stream().forEach(cliente -> logger.debug(cliente.toString()));
	}
	
}
