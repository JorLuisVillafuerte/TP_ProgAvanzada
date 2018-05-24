package edu.usal.dto;
import java.io.Serializable;
public class Clase implements Serializable{

	private static final long serialVersionUID = 2679432650153293313L;
	private Integer NroClase;
	private double tamanio;
	private int cant_mesas;
	private String tipo_pizzaron;
	private Pabellon pabellon_clase;
	
	public Clase() {}
	
	public Clase(Integer nroClase, double tamanio, int cant_mesas, String tipo_pizzaron, Pabellon pabellon_clase) {
		NroClase = nroClase;
		this.tamanio = tamanio;
		this.cant_mesas = cant_mesas;
		this.tipo_pizzaron = tipo_pizzaron;
		this.pabellon_clase = pabellon_clase;
	}


	@Override
	public String toString() {
		return "Clase [NroClase=" + NroClase + ", tamanio=" + tamanio + ", cant_mesas=" + cant_mesas
				+ ", tipo_pizzaron=" + tipo_pizzaron + ", pabellon_clase= " + pabellon_clase + "]";
	}

	public Integer getNroClase() {
		return NroClase;
	}
	public void setNroClase(Integer nroClase) {
		NroClase = nroClase;
	}
	public double getTamanio() {
		return tamanio;
	}
	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}
	public int getCant_mesas() {
		return cant_mesas;
	}
	public void setCant_mesas(int cant_mesas) {
		this.cant_mesas = cant_mesas;
	}
	public String getTipo_pizzaron() {
		return tipo_pizzaron;
	}

	public Pabellon getPabellon_clase() {
		return pabellon_clase;
	}

	public void setPabellon_clase(Pabellon pabellon_clase) {
		this.pabellon_clase = pabellon_clase;
	}

	public void setTipo_pizzaron(String tipo_pizzaron) {
		this.tipo_pizzaron = tipo_pizzaron;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NroClase == null) ? 0 : NroClase.hashCode());
		result = prime * result + cant_mesas;
		result = prime * result + ((pabellon_clase == null) ? 0 : pabellon_clase.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tamanio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo_pizzaron == null) ? 0 : tipo_pizzaron.hashCode());
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
		Clase other = (Clase) obj;
		if (NroClase == null) {
			if (other.NroClase != null)
				return false;
		} else if (!NroClase.equals(other.NroClase))
			return false;
		if (cant_mesas != other.cant_mesas)
			return false;
		if (pabellon_clase == null) {
			if (other.pabellon_clase != null)
				return false;
		} else if (!pabellon_clase.equals(other.pabellon_clase))
			return false;
		if (Double.doubleToLongBits(tamanio) != Double.doubleToLongBits(other.tamanio))
			return false;
		if (tipo_pizzaron == null) {
			if (other.tipo_pizzaron != null)
				return false;
		} else if (!tipo_pizzaron.equals(other.tipo_pizzaron))
			return false;
		return true;
	}
	
	
}
