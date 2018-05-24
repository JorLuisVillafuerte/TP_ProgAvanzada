package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;
import edu.usal.dto.Clase;

public interface ClaseDAO {
	public void addClase(Clase c) throws IOException;
	public void updateClase(Clase c)throws IOException;
	public void deleteClase(Clase c) throws IOException;
	public List<Clase> getAllClase() throws IOException;
}
