package saludos;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saludos")
public class Saludo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private LocalDateTime fecha_hora;
	
	public Saludo() {
		
	}
	
	public Saludo(String nombre, LocalDateTime fecha_hora) {
		if(nombre.length() > 100) {
			throw new IllegalArgumentException("Field 'Nombre' cannot be longer than 100 characters.");
		}
		this.nombre = nombre;
		this.fecha_hora = fecha_hora;
	}
	
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saludo other = (Saludo) obj;
		return Objects.equals(id, other.id);
	}
}
