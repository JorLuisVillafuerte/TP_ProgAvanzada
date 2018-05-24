package edu.usal.dto;

public class Mantenimiento extends Empleado{
	
	private static final long serialVersionUID = 359597198532609791L;
	private Pabellon mant_pabellon;

	public Mantenimiento() {}

	public Mantenimiento(Integer idEmpleado, String nombre, String apellido, int dni, String direccion, double sueldo,Pabellon p) {
		super(idEmpleado, nombre, apellido, dni, direccion, sueldo);
		this.mant_pabellon = p;
	}

	public Pabellon getMant_pabellon() {
		return mant_pabellon;
	}

	public void setMant_pabellon(Pabellon mant_pabellon) {
		this.mant_pabellon = mant_pabellon;
	}

	@Override
	public String toString() {
		return "Mantenimiento ["+super.toString() +", mant_pabellon=" + mant_pabellon + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mant_pabellon == null) ? 0 : mant_pabellon.hashCode());
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
		Mantenimiento other = (Mantenimiento) obj;
		if (mant_pabellon == null) {
			if (other.mant_pabellon != null)
				return false;
		} else if (!mant_pabellon.equals(other.mant_pabellon))
			return false;
		return true;
	}
	
	
}
