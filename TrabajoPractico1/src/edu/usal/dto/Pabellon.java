package edu.usal.dto;
import java.io.Serializable;

public class Pabellon implements Serializable{

	private static final long serialVersionUID = 1776610966190972180L;
	private Integer idpab;
	private String nombre;
	private String direccion;
	private Double tamanio;
	
	public Pabellon() {}
	public Pabellon(Integer idpab, String nombre, String direccion, Double tamanio) {
		super();
		this.idpab = idpab;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tamanio = tamanio;
	}
	public Integer getIdpab() {
		return idpab;
	}
	public void setIdpab(Integer idpab) {
		this.idpab = idpab;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Double getTamanio() {
		return tamanio;
	}
	public void setTamanio(Double tamanio) {
		this.tamanio = tamanio;
	}
	@Override
	public String toString() {
		return "Pabellon [idpab=" + idpab + ", nombre=" + nombre + ", direccion=" + direccion + ", tamanio=" + tamanio
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((idpab == null) ? 0 : idpab.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tamanio == null) ? 0 : tamanio.hashCode());
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
		Pabellon other = (Pabellon) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idpab == null) {
			if (other.idpab != null)
				return false;
		} else if (!idpab.equals(other.idpab))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tamanio == null) {
			if (other.tamanio != null)
				return false;
		} else if (!tamanio.equals(other.tamanio))
			return false;
		return true;
	}
	
	
}
