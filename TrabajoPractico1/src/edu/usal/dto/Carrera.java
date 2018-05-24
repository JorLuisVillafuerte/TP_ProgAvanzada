package edu.usal.dto;

import java.io.Serializable;

public class Carrera implements Serializable{
	
	private static final long serialVersionUID = 2707574884128617092L;
	private Integer idCarrera;
	private String nombre;
	private int cant_materias;
	private int cant_anios;
	
	public Carrera() {}
	
	public Carrera(Integer idCarrera, String nombre, int cant_materias, int cant_anios) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.cant_materias = cant_materias;
		this.cant_anios = cant_anios;
	}
	
	public Integer getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCant_materias() {
		return cant_materias;
	}
	public void setCant_materias(int cant_materias) {
		this.cant_materias = cant_materias;
	}
	public int getCant_anios() {
		return cant_anios;
	}
	public void setCant_anios(int cant_anios) {
		this.cant_anios = cant_anios;
	}
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + ", cant_materias=" + cant_materias
				+ ", cant_anios=" + cant_anios + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cant_anios;
		result = prime * result + cant_materias;
		result = prime * result + ((idCarrera == null) ? 0 : idCarrera.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		if (cant_anios != other.cant_anios)
			return false;
		if (cant_materias != other.cant_materias)
			return false;
		if (idCarrera == null) {
			if (other.idCarrera != null)
				return false;
		} else if (!idCarrera.equals(other.idCarrera))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
