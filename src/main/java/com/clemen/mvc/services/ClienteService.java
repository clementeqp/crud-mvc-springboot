package com.clemen.mvc.services;

import com.clemen.mvc.entities.Cliente;

import java.util.List;

public interface ClienteService {
	
	void guardar(Cliente cliente);

	List<Cliente> buscarTodos();

	List<Cliente> buscarNombreApellido(String nombre, String apellido);

	void borrar(Cliente cliente);

	Cliente buscarPorId(Long id);

	void crearCliente(Cliente cliente);

	void mostrarTodos();
}
