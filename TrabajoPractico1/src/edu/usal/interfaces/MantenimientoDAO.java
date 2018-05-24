package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.dto.Mantenimiento;

public interface MantenimientoDAO {
	public void addMantenimiento(Mantenimiento mant) throws IOException;
	public void updateMantenimiento(Mantenimiento mant)throws IOException;
	public void deleteMantenimiento(Mantenimiento mant) throws IOException;
	public List<Mantenimiento> getAllMantenimiento() throws IOException;
}
