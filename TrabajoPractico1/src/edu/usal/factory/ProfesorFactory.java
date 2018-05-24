package edu.usal.factory;

import edu.usal.implementacionA.ProfesorImpFileString;
import edu.usal.implementacionB.ProfesorImpFileStream;
import edu.usal.interfaces.ProfesorDAO;

public class ProfesorFactory {
	
	public static ProfesorDAO getProfesorDAO(String datasource) {
		if(datasource.equalsIgnoreCase("filestring")) {
			return new ProfesorImpFileString();
		
		}else if(datasource.equalsIgnoreCase("filestream")) {
			return new ProfesorImpFileStream();
		}
		return null;
		}
}
