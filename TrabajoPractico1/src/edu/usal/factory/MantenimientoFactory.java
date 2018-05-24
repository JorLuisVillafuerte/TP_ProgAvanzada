package edu.usal.factory;

import edu.usal.implementacionA.MantenimientoImpFileString;
import edu.usal.implementacionB.MantenimientoImpFileStream;
import edu.usal.interfaces.MantenimientoDAO;

public class MantenimientoFactory {
	public static MantenimientoDAO getMantenimientoDAO(String datasource) {
		if(datasource.equalsIgnoreCase("filestring")) {
			return new MantenimientoImpFileString();
		
		}else if(datasource.equalsIgnoreCase("filestream")) {
			return new MantenimientoImpFileStream();
		}
		return null;
	}
}
