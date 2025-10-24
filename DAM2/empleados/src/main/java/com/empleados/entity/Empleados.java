package com.empleados.entity;


import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado")
    private Integer idEmpleados;


    @Column(name = "nombre")
    private String nombre;


    @Column(name = "apellido")
    private String apellido;


    @Column(name = "email")
    private String email;


	public Integer getIdEmpleados() {
		return idEmpleados;
	}


	public void setIdEmpleados(Integer idEmpleados) {
		this.idEmpleados = idEmpleados;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Empleados [idEmpleados=" + idEmpleados + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
				+ email + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idEmpleados);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return Objects.equals(idEmpleados, other.idEmpleados);
	}
}
