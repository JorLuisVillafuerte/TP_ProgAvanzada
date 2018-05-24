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
import edu.usal.dto.Carrera;
import edu.usal.interfaces.CarreraDAO;

public class CarreraImpFileStream implements CarreraDAO{
	private File file;
	private ObjectInputStream objIn;
	private ObjectOutputStream objOut;
	
	@Override
	public void addCarrera(Carrera car) throws IOException {
		this.file = new File("D://jorge/carreras.txt");	
		List<Carrera> lista = null;
		if(!file.exists()){
			lista = new ArrayList<>();	
		}else{
			lista = getAllCarrera();
		}
		lista.add(car);
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(lista);
		objOut.close();
	}

	@Override
	public void updateCarrera(Carrera car) throws IOException {
		this.file = new File("D://jorge/carreras.txt");
		List<Carrera> lista = null;
		if(!file.exists()) {
			System.out.println("No hay registros para realizar update!");
			throw new FileNotFoundException("No hay registros para realizar update!");
		}else {
			lista = getAllCarrera();
			int contador = 0;
			for(Carrera c: lista) {
				if(c.getIdCarrera().equals(car.getIdCarrera())) {
					lista.set(contador,car);
				}
			}
			this.objOut = new ObjectOutputStream(new FileOutputStream(file));
			objOut.writeObject(lista);
			objOut.close();
		}
		
	}

	@Override
	public void deleteCarrera(Carrera car) throws IOException {
		this.file = new File("D://jorge/carreras.txt");
		List<Carrera> lista = null;
		if(!file.exists()) {
			System.out.println("No hay registros para borrar!");
			throw new FileNotFoundException("No hay registros para borrar!");
		}else {
			lista = getAllCarrera();
			int contador = 0;
			for(Carrera c: lista) {
				if(c.getIdCarrera().equals(car.getIdCarrera())) {
					lista.remove(contador);
				}
			}
			this.objOut = new ObjectOutputStream(new FileOutputStream(file));
			objOut.writeObject(lista);
			objOut.close();
		}
	}

	@Override
	public List<Carrera> getAllCarrera() throws IOException {
		this.file = new File("D://jorge/carreras.txt");
		List<Carrera> lista_carreras = null;
		try {
				if(!file.exists()){file.createNewFile();}
				this.objIn = new ObjectInputStream(new FileInputStream(file));
				lista_carreras = (ArrayList<Carrera>) objIn.readObject();
				objIn.close();
				
		}catch(ClassNotFoundException e) {
				throw new RuntimeException(e.getMessage());
		}
		return lista_carreras;

	}

}
