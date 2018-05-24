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
import edu.usal.dto.Mantenimiento;
import edu.usal.interfaces.MantenimientoDAO;
import edu.usal.util.PropertiesUtil;

public class MantenimientoImpFileStream implements MantenimientoDAO{
	private File file;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	@Override
	public void addMantenimiento(Mantenimiento mant) throws IOException {
		List<Mantenimiento> lista_add = getAllMantenimiento();
		lista_add.add(mant);
		EscribirArchivo(lista_add);
	}

	@Override
	public void updateMantenimiento(Mantenimiento mant) throws IOException {
		List<Mantenimiento> lista_update = getAllMantenimiento();
		if (lista_update.isEmpty()) {
			System.out.println("No hay registros para realizar update!");
		}else {
			int contador = 0; 
			for (Mantenimiento m: lista_update) {
				if (m.getIdEmpleado().equals(mant.getIdEmpleado())) {
					lista_update.set(contador,mant);
					EscribirArchivo(lista_update);
					break;
				}
				contador++;
			}
		}
	}

	@Override
	public void deleteMantenimiento(Mantenimiento mant) throws IOException {
		List<Mantenimiento> lista_delete = getAllMantenimiento();
		if (lista_delete.isEmpty()) {
			System.out.println("No hay registros para borrar!");
		}else {
			int contador = 0; 
			for (Mantenimiento m: lista_delete) {
				if (m.getIdEmpleado().equals(mant.getIdEmpleado())) {
					lista_delete.set(contador,mant);
					EscribirArchivo(lista_delete);
					break;
				}
				contador++;
			}
		}
	}

	@Override
	public List<Mantenimiento> getAllMantenimiento() throws IOException {
		this.file = new File(PropertiesUtil.getPath("mantenimiento"));
		List<Mantenimiento> lista_mantenimiento = null;
		if(!file.exists()) {
			lista_mantenimiento = new ArrayList<>();
			EscribirArchivo(lista_mantenimiento);
		}
		this.objIn = new ObjectInputStream(new FileInputStream(file));
		try {
			lista_mantenimiento = (ArrayList<Mantenimiento>) objIn.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		objIn.close();
		return lista_mantenimiento;
	}
	private void EscribirArchivo(List<Mantenimiento> mant) throws FileNotFoundException, IOException {
		this.file = new File(PropertiesUtil.getPath("mantenimiento"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(mant);
		objOut.close();
	}
}
