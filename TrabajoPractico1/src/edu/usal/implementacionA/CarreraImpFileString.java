package edu.usal.implementacionA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.usal.dto.Carrera;
import edu.usal.interfaces.CarreraDAO;

public class CarreraImpFileString implements CarreraDAO {

	private File file;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	@Override
	public void addCarrera(Carrera car) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCarrera(Carrera car) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCarrera(Carrera car) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Carrera> getAllCarrera() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
