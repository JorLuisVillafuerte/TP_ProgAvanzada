package edu.usal.implementacionB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dto.Alumno;
import edu.usal.interfaces.AlumnoDAO;
import edu.usal.util.PropertiesUtil;

public class AlumnoImpFileStream implements AlumnoDAO{
	
	private File file;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	
	public void addAlumno(Alumno alum) throws IOException {
		List<Alumno> lista_add = getAllAlumno();
		lista_add.add(alum);
		EscribirArchivo(lista_add);
	}

	@Override
	public void updateAlumno(Alumno alum) throws IOException {
		List<Alumno> lista_update = getAllAlumno();
		if(lista_update.isEmpty()) {
			System.out.println("No hay registros para realizar update!");
		}else {
			int contador = 0;
			for(Alumno a: lista_update) {
				if(a.getIdAlumno().equals(alum.getIdAlumno())) {
					lista_update.set(contador,alum);
				}
				contador++;
			}
			EscribirArchivo(lista_update);
		}
	}

	@Override
	public void deleteAlumno(Alumno alum) throws IOException {
		List<Alumno> lista_delete = getAllAlumno();
		if(lista_delete.isEmpty()) {
			System.out.println("No hay registros para borrar!");
		}else {
			int contador = 0;
			for(Alumno a: lista_delete) {
				if(a.getIdAlumno().equals(alum.getIdAlumno())) {
					lista_delete.remove(contador);
				}
				contador++;
			}
			EscribirArchivo(lista_delete);
		}
	}

	@Override
	public List<Alumno> getAllAlumno() throws IOException {
		this.file = new File(PropertiesUtil.getPath("alumno"));
		List<Alumno> lista_alumnos = null;
		if(!file.exists()) {
			lista_alumnos = new ArrayList<Alumno>();
			EscribirArchivo(lista_alumnos);
		}else {
			this.objIn = new ObjectInputStream(new FileInputStream(file));
			try {
				lista_alumnos = (ArrayList<Alumno>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			
			}
			objIn.close();
		}
		
		return lista_alumnos;
	}
	private void EscribirArchivo(List<Alumno> list_a) throws FileNotFoundException, IOException {
		this.file = new File(PropertiesUtil.getPath("alumno"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(list_a);
		objOut.close();
	}

}

