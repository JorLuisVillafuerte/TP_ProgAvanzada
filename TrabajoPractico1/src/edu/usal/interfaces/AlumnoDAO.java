package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;
import edu.usal.dto.Alumno;

public interface AlumnoDAO{
	public void addAlumno(Alumno alum) throws IOException;
	public void updateAlumno(Alumno alum)throws IOException;
	public void deleteAlumno(Alumno alum) throws IOException;
	public List<Alumno> getAllAlumno() throws IOException;

}
