package edu.usal.implementacionB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import edu.usal.dto.Administrativo;
import edu.usal.interfaces.AdministrativoDAO;
import edu.usal.util.PropertiesUtil;

public class AdministrativoImpFileStream implements AdministrativoDAO{

	private File file;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	@Override
	public void addAdministrativo(Administrativo adm) throws IOException {
		List<Administrativo> lista_add = getAllAdmin();
		lista_add.add(adm);
		EscribirArchivo(lista_add);
	}

	@Override
	public void updateAdministrativo(Administrativo adm) throws IOException {
		List<Administrativo> lista_update = getAllAdmin();
		if(lista_update.isEmpty()) {
			System.out.println("No hay registros para realizar update!");
		}else {
			int contador = 0;
			for(Administrativo a: lista_update) {
				if (a.getIdEmpleado().equals(adm.getIdEmpleado())) {
					lista_update.set(contador, adm);
					EscribirArchivo(lista_update);
					break;
				}
				contador++;
			}
		}
		
	}

	@Override
	public void deleteAdministrativo(Administrativo adm) throws IOException {
		List<Administrativo> lista_delete = getAllAdmin();
		if(lista_delete.isEmpty()) {
			System.out.println("No hay registros para borrar!");
		}else {
			int contador = 0;
			for(Administrativo a: lista_delete) {
				if (a.getIdEmpleado().equals(adm.getIdEmpleado())) {
					lista_delete.remove(contador);
					EscribirArchivo(lista_delete);
					break;
				}
				contador++;
			}
		}
	}

	@Override
	public List<Administrativo> getAllAdmin() throws IOException {
		this.file = new File(PropertiesUtil.getPath("administrativo"));
		List<Administrativo> lista_administrativo = null;
		if(!file.exists()) {
			lista_administrativo = new ArrayList<>();
			EscribirArchivo(lista_administrativo);
		}
		this.objIn = new ObjectInputStream(new FileInputStream(file));
		try {
			lista_administrativo = (ArrayList<Administrativo>) objIn.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		objIn.close();
		return lista_administrativo;
	}
	private void EscribirArchivo(List<Administrativo> adm) throws FileNotFoundException, IOException {
		this.file = new File(PropertiesUtil.getPath("administrativo"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(adm);
		objOut.close();
	}

}
