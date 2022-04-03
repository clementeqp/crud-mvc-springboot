package com.clemen.mvc.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="Cliente")
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="FECHA")
	private Date fecha;

	@Column(name="EMAIL")
	private String email;
	
	public Cliente() {};

	public Cliente(String nombre, String apellidos, Date fecha, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.email = email;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha + ", email="
				+ email + "]";
	}
	
}
