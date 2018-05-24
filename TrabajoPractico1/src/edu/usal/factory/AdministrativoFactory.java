package edu.usal.factory;

import edu.usal.implementacionA.AdministrativoImpFileString;
import edu.usal.implementacionB.AdministrativoImpFileStream;
import edu.usal.interfaces.AdministrativoDAO;

public class AdministrativoFactory {
	public static AdministrativoDAO getAdministrativoDAO(String datasource) {
		if(datasource.equalsIgnoreCase("filestring")) {
			return new AdministrativoImpFileString();
		
		}else if(datasource.equalsIgnoreCase("filestream")) {
			return new AdministrativoImpFileStream();
		}
		return null;
	}
}
