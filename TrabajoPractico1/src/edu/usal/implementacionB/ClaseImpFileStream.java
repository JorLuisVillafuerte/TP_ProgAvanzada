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
import edu.usal.dto.Clase;

import edu.usal.interfaces.ClaseDAO;
import edu.usal.util.PropertiesUtil;

public class ClaseImpFileStream implements ClaseDAO{
	//Declaro variables a usar para Escribir y leer archivo
	private File file;
	private ObjectInputStream objIn;
	private ObjectOutputStream objOut;
	
	@Override
	/*Recibe en una lista todos los registros.
	 * Añado el objeto que recibo por parametro.
	 * y mando a escribir la lista al archivo.
	 * */
	public void addClase(Clase c) throws IOException {
		List<Clase> lista = getAllClase();
		lista.add(c);
		EscribirArchivo(lista);
	}
	
	/*Este metodo 
	 * Recibe en una lista todos los registros.
	 * Pregunto si la lista esta vacia o no.
	 * Luego recorro la lista y evaluo si alguno de los id
	 * de los registros coinciden(ya que cada uno es unico)
	 * y si coinciden prosigo a setear en ese lugar el objeto
	 * recibido por parametro.
	 * Mando a escribir al archivo la lista.
	 * */
	@Override
	public void updateClase(Clase c) throws IOException {
		List<Clase> list_update = getAllClase();
		if(list_update.isEmpty()) {
			System.out.println("No hay registros para modificar!");
		}else {
			int contador = 0;
			for(Clase p: list_update){
				if(p.getNroClase().equals(c.getNroClase())) {
					list_update.set(contador,c);
				}
				contador++;
			}
			EscribirArchivo(list_update);
		}
	}

	/*Este metodo 
	 * Recibe en una lista todos los registros.
	 * Pregunto si la lista esta vacia o no.
	 * Luego recorro la lista y evaluo si alguno de los id
	 * de los registros coinciden(ya que cada uno es unico)
	 * y si coinciden prosigo a eliminar en ese lugar el objeto.
	 * Mando a escribir al archivo la lista.
	 * */
	@Override
	public void deleteClase(Clase c) throws IOException {
		List<Clase> list_delete = getAllClase();
		if(list_delete.isEmpty()) {
			System.out.println("No hay registros para eliminar!");
		}else {
			int contador = 0;
			for(Clase p: list_delete){
				if(p.getNroClase().equals(c.getNroClase())) {
					list_delete.remove(contador);
				}
				contador++;
			}
			EscribirArchivo(list_delete);
		}
	}
	/*Declaro la lista a retornar.
	 * si el archivo no existe instancio la lista vacia
	 * y la escribo en el archivo.
	 * Si ya existe para por el else y leo la lista
	 * y luego retorno la lista ya sea sin nada si es 
	 * que el archivo aun no existe o con los registros
	 * que estaban en el archivo
	 * */
	@Override
	public List<Clase> getAllClase() throws IOException {
		this.file = new File(PropertiesUtil.getPath("clase"));
		List<Clase> lista_clases = null;
		try {
			if(!file.exists()){
				lista_clases = new ArrayList<Clase>();
			}else {
				this.objIn = new ObjectInputStream(new FileInputStream(file));
				lista_clases = (ArrayList<Clase>) objIn.readObject();
				objIn.close();
			}
		}catch(ClassNotFoundException e) {
				throw new RuntimeException(e.getMessage());
		}
		return lista_clases;
	}
	
	/*Ya que en 3 metodos escribo el archivo lo coloco
	 * todo en un metodo donde recibo la lista a ingresar
	 * el archivo*/
	private void EscribirArchivo(List<Clase> lista_c) throws IOException {
		this.file = new File(PropertiesUtil.getPath("clase"));
		this.objOut = new ObjectOutputStream(new FileOutputStream(file));
		objOut.writeObject(lista_c);
		objOut.close();
	}
	
}
