package edu.usal.factory;

import edu.usal.implementacionA.ClaseImpFileString;
import edu.usal.implementacionB.ClaseImpFileStream;
import edu.usal.interfaces.ClaseDAO;

public class ClaseFactory {
	
	public static ClaseDAO getClaseDAO(String datasource) {
		if(datasource.equalsIgnoreCase("filestring")) {
			return new ClaseImpFileString();
		
		}else if(datasource.equalsIgnoreCase("filestream")) {
			return new ClaseImpFileStream();
		}
		return null;
	}
	
}
