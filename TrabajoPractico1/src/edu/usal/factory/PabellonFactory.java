package edu.usal.factory;

import edu.usal.implementacionA.PabellonImpFileString;
import edu.usal.implementacionB.PabellonImpFileStream;
import edu.usal.interfaces.PabellonDAO;

public class PabellonFactory {
	public static PabellonDAO getPabellonDAO(String datasource){
		
	if(datasource.equalsIgnoreCase("filestring"))
	{
		return new PabellonImpFileString();
		
	}else if(datasource.equalsIgnoreCase("filestream"))
	{
		return new PabellonImpFileStream(); 
	}
	return null;
	}
}
