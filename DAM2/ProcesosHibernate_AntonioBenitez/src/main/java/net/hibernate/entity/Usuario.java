package net.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre) {
		if(nombre.length() > 255) {
			throw new IllegalArgumentException("El campo Nombre no puede tener más de 255 caracteres.");
		}
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.length() > 255) {
			throw new IllegalArgumentException("El campo Nombre no puede tener más de 255 caracteres.");
		}
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return String.format("USUARIO [ID = %d, Nombre = %s]",
				this.id,this.nombre);
	}
}
