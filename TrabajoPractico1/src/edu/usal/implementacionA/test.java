package edu.usal.implementacionA;

import java.io.IOException;
import java.util.List;

import edu.usal.dto.Clase;
import edu.usal.dto.Pabellon;
import edu.usal.factory.ClaseFactory;
import edu.usal.factory.PabellonFactory;
import edu.usal.interfaces.ClaseDAO;
import edu.usal.interfaces.PabellonDAO;

public class test {

	public static void main(String[] args) {

		PabellonDAO imp = PabellonFactory.getPabellonDAO("filestring");
		Pabellon p = new Pabellon(1,"Jorge","usal",20.00);
		Pabellon p1 = new Pabellon(2,"Jose","usal pilar",10.99);
		
		//ClaseDAO impClase = ClaseFactory.getClaseDAO("fileStream");

		Clase c = new Clase(162,20.20,20,"Madera",p);
		
		try {
			imp.addPabellon(p);
			imp.addPabellon(p1);
			//imp.deletePabellon(p1);
			
			//impClase.addClase(c);
			//List<Clase> lista_ver = impClase.getAllClase();
			/*for(Clase x: lista_ver) {
				System.out.println(x.toString());
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
