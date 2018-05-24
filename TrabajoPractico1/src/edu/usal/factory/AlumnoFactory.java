package edu.usal.factory;

import edu.usal.implementacionA.AlumnoImpFileString;
import edu.usal.implementacionB.AlumnoImpFileStream;
import edu.usal.interfaces.AlumnoDAO;

public class AlumnoFactory {
	
	public static AlumnoDAO getAlumnoDAO(String datasource) {
	if(datasource.equalsIgnoreCase("filestring")) {
		return new AlumnoImpFileString();
	
	}else if(datasource.equalsIgnoreCase("filestream")) {
		return new AlumnoImpFileStream();
	}
	return null;
	}
}
