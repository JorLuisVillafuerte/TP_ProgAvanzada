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
import edu.usal.dto.Profesor;
import edu.usal.interfaces.ProfesorDAO;
import edu.usal.util.PropertiesUtil;

public class ProfesorImpFileStream implements ProfesorDAO{
	private File file;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	@Override
	public void addProfesor(Profesor prof) throws IOException {
		List<Profesor> lista_add = getAllProfesor();
		lista_add.add(prof);
		EscribirArchivo(lista_add);
	}
	@Override
	public void updateProfesor(Profesor prof) throws IOException {
		List<Profesor> lista_update = getAllProfesor();
		if(lista_update.isEmpty()) {
			System.out.println("No hay registros para realizar update!");
		}else {
			int contador = 0;
			for(Profesor p: lista_update) {
				if(p.getIdEmpleado().equals(prof.getIdEmpleado())) {
					lista_update.set(contador, prof);
				}
				contador++;
			}
			EscribirArchivo(lista_update);
		}
	}
	@Override
	public void deleteProfesor(Profesor prof) throws IOException {
		List<Profesor> lista_delete = getAllProfesor();
		if(lista_delete.isEmpty()) {
			System.out.println("No hay registros para borrar!");
		}else {
			int contador = 0;
			for(Profesor p: lista_delete) {
				if(p.getIdEmpleado().equals(prof.getIdEmpleado())) {
					lista_delete.remove(contador);
				}
				contador++;
			}
			EscribirArchivo(lista_delete);
		}
	}
	@Override
	public List<Profesor> getAllProfesor() throws IOException {
		this.file = new File(PropertiesUtil.getPath("profesor"));
		List<Profesor> lista_profesores = null;
		if(!file.exists()) {
			lista_profesores = new ArrayList<>();
			EscribirArchivo(lista_profesores);
		}
		this.objIn = new ObjectInputStream(new FileInputStream(file));
		try {
			lista_profesores = (ArrayList<Profesor>) objIn.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		objIn.close();
		return lista_profesores;
	}
	private void EscribirArchivo(List<Profesor> prof) throws FileNotFoundException, IOException {
		this.file = new File(PropertiesUtil.getPath("profesor"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(prof);
		objOut.close();
	}

}
