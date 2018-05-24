package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;
import edu.usal.dto.Profesor;

public interface ProfesorDAO {
	public void addProfesor(Profesor prof) throws IOException;
	public void updateProfesor(Profesor prof)throws IOException;
	public void deleteProfesor(Profesor prof) throws IOException;
	public List<Profesor> getAllProfesor() throws IOException;

}
