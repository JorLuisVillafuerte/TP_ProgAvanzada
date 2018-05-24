package edu.usal.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
public static Properties prop;

	public static String getPathFileString(String tipo){	
		prop = new Properties();
		
		try{
			prop.load(new FileReader("configuracionFileString.properties"));
			
		}catch(IOException e){
			System.out.println("Ocurrio un error al cargar el archivo properties!");
			e.printStackTrace();
		}
		
		switch (tipo) {
		case "pabellon":
			return prop.getProperty("pathPabellon");
		case "clase" :
			return prop.getProperty("pathClase");
		case "carrera":
			return prop.getProperty("pathCarrera");
		case "alumno" :
			return prop.getProperty("pathAlumno");
		case "profesor" :
			return prop.getProperty("pathProfesor");
		case "administrativo" :
			return prop.getProperty("pathAdministrativo");
		case "mantenimiento" :
			return prop.getProperty("pathMantenimiento");
		default:
			return null;
		}
	
}
	public static String getPath(String tipo){	
		prop = new Properties();
		
		try{
			prop.load(new FileReader("configuracion.properties"));
			
		}catch(IOException e){
			System.out.println("Ocurrio un error al cargar el archivo properties!");
			e.printStackTrace();
		}
		
		switch (tipo) {
		case "pabellon":
			return prop.getProperty("pathPabellon");
		case "clase" :
			return prop.getProperty("pathClase");
		case "carrera":
			return prop.getProperty("pathCarrera");
		case "alumno" :
			return prop.getProperty("pathAlumno");
		case "profesor" :
			return prop.getProperty("pathProfesor");
		case "administrativo" :
			return prop.getProperty("pathAdministrativo");
		case "mantenimiento" :
			return prop.getProperty("pathMantenimiento");
		default:
			return null;
		}
		
	}
}
