package edu.usal.implementacionB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dto.Clase;
import edu.usal.dto.Pabellon;
import edu.usal.dto.Profesor;
import edu.usal.factory.ClaseFactory;
import edu.usal.factory.PabellonFactory;
import edu.usal.interfaces.ClaseDAO;
import edu.usal.interfaces.PabellonDAO;

public class main {

	public static void main(String[] args)  {
		
		PabellonDAO imp = PabellonFactory.getPabellonDAO("filestream");
		Pabellon p = new Pabellon(1,"Jorge villafuerte","usal pilar",20.00);
		Pabellon p1 = new Pabellon(2,"Jose","usal pilar",10.99);
		
		ClaseDAO impClase = ClaseFactory.getClaseDAO("fileStream");

		Clase c = new Clase(162,59.20,20,"Madera",p);
		
			
		
		try {
			//imp.addPabellon(p);
			//imp.addPabellon(p1);
			//imp.updatePabellon(p);
			
			impClase.updateClase(c);
			List<Clase> lista_ver = impClase.getAllClase();
			for(Clase x: lista_ver) {
				System.out.println(x.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
