package com.clemen.mvc.repositories;

import com.clemen.mvc.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);
	Optional<Cliente> findFirstByNombre(String nombre);
	
}
