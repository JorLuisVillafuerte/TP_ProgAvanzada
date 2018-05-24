package edu.usal.dto;

import java.io.Serializable;

public class Alumno implements Serializable{

	private static final long serialVersionUID = 2648252423981884702L;
	private Integer idAlumno;
	private String nombre;
	private String apellido;
	private int dni;
	private String direccion;
	private Carrera alumno_carrera;
	
	public Alumno() {}
	public Alumno(Integer idAlumno, String nombre, String apellido, int dni, String direccion, Carrera alumno_carrera) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.alumno_carrera = alumno_carrera;
	}
	
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Carrera getAlumno_carrera() {
		return alumno_carrera;
	}
	public void setAlumno_carrera(Carrera alumno_carrera) {
		this.alumno_carrera = alumno_carrera;
	}
	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", direccion=" + direccion + ", alumno_carrera=" + alumno_carrera + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno_carrera == null) ? 0 : alumno_carrera.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + dni;
		result = prime * result + ((idAlumno == null) ? 0 : idAlumno.hashCode());
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
		Alumno other = (Alumno) obj;
		if (alumno_carrera == null) {
			if (other.alumno_carrera != null)
				return false;
		} else if (!alumno_carrera.equals(other.alumno_carrera))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dni != other.dni)
			return false;
		if (idAlumno == null) {
			if (other.idAlumno != null)
				return false;
		} else if (!idAlumno.equals(other.idAlumno))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
