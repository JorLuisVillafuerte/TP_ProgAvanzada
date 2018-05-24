package edu.usal.implementacionB;
import java.util.ArrayList;
import java.util.List;

import edu.usal.dto.Clase;
import edu.usal.dto.Pabellon;
import edu.usal.interfaces.PabellonDAO;
import edu.usal.util.PropertiesUtil;
import java.io.*;

public class PabellonImpFileStream implements PabellonDAO{

	private File archivo;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	
	@Override
	public void addPabellon(Pabellon pab) throws IOException {
		List<Pabellon> list = getAllPabellon();
		list.add(pab);
		EscribirArchivo(list);
	}

	@Override
	public void updatePabellon(Pabellon pab) throws IOException {
		List<Pabellon> lista_update = getAllPabellon();
		if(lista_update.isEmpty()) {
			System.out.println("No hay registros para realizar update");
		}else{
			int contador = 0;
			for(Pabellon p: lista_update){
				if(p.getIdpab().equals(pab.getIdpab())) {
					lista_update.set(contador, pab);
					EscribirArchivo(lista_update);
					break;
				}
				contador++;
			}
			
		}
	}

	@Override
	public void deletePabellon(Pabellon pab) throws IOException {
		List<Pabellon> lista_delete = getAllPabellon();
		if(lista_delete.isEmpty()) {
			System.out.println("No hay registros para realizar eliminar");
		}else {
			int contador = 0;
			for(Pabellon p: lista_delete){
				if(p.getIdpab().equals(pab.getIdpab())) {
					lista_delete.remove(contador);
					EscribirArchivo(lista_delete);
					break;
				}
				contador++; 
			}
			
		}
		
	}

	@Override
	public List<Pabellon> getAllPabellon() throws IOException {
		this.archivo = new File(PropertiesUtil.getPath("pabellon"));
		List<Pabellon> lista_pabellones = null;
		try
		{	
			if(!archivo.exists()) {
				lista_pabellones = new ArrayList<Pabellon>();
				EscribirArchivo(lista_pabellones);
			}else{
				this.objIn = new ObjectInputStream(new FileInputStream(archivo));
				lista_pabellones = (ArrayList<Pabellon>)objIn.readObject();	
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return lista_pabellones;
	}
	
	private void EscribirArchivo(List<Pabellon> lista_p) throws IOException {
		this.archivo = new File(PropertiesUtil.getPath("pabellon"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(archivo));
		objOut.writeObject(lista_p);
		objOut.close();
	}
}
