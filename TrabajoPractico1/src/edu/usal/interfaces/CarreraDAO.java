package edu.usal.interfaces;
import java.io.IOException;
import java.util.List;
import edu.usal.dto.Carrera;

public interface CarreraDAO {
	
	public void addCarrera(Carrera car) throws IOException;
	public void updateCarrera(Carrera car)throws IOException;
	public void deleteCarrera(Carrera car) throws IOException;
	public List<Carrera> getAllCarrera() throws IOException;
}
