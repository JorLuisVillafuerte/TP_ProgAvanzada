package edu.usal.factory;

import edu.usal.implementacionA.CarreraImpFileString;
import edu.usal.implementacionB.CarreraImpFileStream;
import edu.usal.interfaces.CarreraDAO;

public class CarreraFactory {
	public static CarreraDAO getCarreraDAO(String datasource) {
		if(datasource.equalsIgnoreCase("filestring")) {
			return new CarreraImpFileString();
		
		}else if(datasource.equalsIgnoreCase("filestream")) {
			return new CarreraImpFileStream();
		}
		return null;
	}
}
