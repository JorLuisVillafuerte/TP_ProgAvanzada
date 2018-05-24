package edu.usal.dto;

public class Profesor extends Empleado{
	
	private static final long serialVersionUID = 7268386456415246728L;
	private Clase profesor_clase;

	public Profesor(Integer idEmpleado, String nombre, String apellido, int dni, String direccion, double sueldo,Clase profesor_clase) {
		super(idEmpleado,nombre,apellido,dni,direccion,sueldo);
		this.profesor_clase = profesor_clase;
	}

	public Clase getProfesor_clase() {
		return profesor_clase;
	}

	public void setProfesor_clase(Clase profesor_clase) {
		this.profesor_clase = profesor_clase;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((profesor_clase == null) ? 0 : profesor_clase.hashCode());
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
		Profesor other = (Profesor) obj;
		if (profesor_clase == null) {
			if (other.profesor_clase != null)
				return false;
		} else if (!profesor_clase.equals(other.profesor_clase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor ["+super.toString()+", profesor_clase=" + profesor_clase + "]";
	}
	
	
}
