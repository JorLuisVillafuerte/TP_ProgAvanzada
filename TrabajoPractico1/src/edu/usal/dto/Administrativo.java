package edu.usal.dto;

public class Administrativo extends Empleado{
	
	private static final long serialVersionUID = 8569339754684413736L;
	private Pabellon adm_pabellon;

	public Administrativo() {}

	public Administrativo(Integer idEmpleado, String nombre, String apellido, int dni, String direccion,double sueldo,Pabellon p) {
		super(idEmpleado, nombre, apellido, dni, direccion, sueldo);
		this.adm_pabellon = p;
	}

	public Pabellon getAdm_pabellon() {
		return adm_pabellon;
	}

	public void setAdm_pabellon(Pabellon adm_pabellon) {
		this.adm_pabellon = adm_pabellon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adm_pabellon == null) ? 0 : adm_pabellon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrativo other = (Administrativo) obj;
		if (adm_pabellon == null) {
			if (other.adm_pabellon != null)
				return false;
		} else if (!adm_pabellon.equals(other.adm_pabellon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrativo ["+super.toString() +", adm_pabellon= " + adm_pabellon +"]";
	}
	
	
}
