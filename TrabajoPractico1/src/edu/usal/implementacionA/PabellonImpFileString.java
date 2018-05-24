package edu.usal.implementacionA;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import edu.usal.dto.Pabellon;
import edu.usal.interfaces.PabellonDAO;
import edu.usal.util.PropertiesUtil;

public class PabellonImpFileString implements PabellonDAO{
	
	private File file;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	@Override
	public void addPabellon(Pabellon pab) throws IOException {
		file = new File(PropertiesUtil.getPathFileString("pabellon"));
		
		/*bw = new BufferedWriter(new FileWriter(file,true));
		bw.write(this.pabellonToString(pab));
		bw.write("\n");
		bw.close();*/
		PrintWriter pw = new PrintWriter(new FileWriter(file,true));
		pw.println(this.pabellonToString(pab));
		pw.close();
	}

	@Override
	public void updatePabellon(Pabellon pab) throws IOException {
		file = new File(PropertiesUtil.getPathFileString("pabellon"));
		Scanner scan = new Scanner(file);
		String straux[] = null;
		List<String> lista_update = new ArrayList<>();
		int contador = 0;
		while(scan.hasNext()){
			lista_update.add(scan.nextLine());
			straux = lista_update.get(contador).split(";");
			if(Integer.parseInt(straux[0]) == pab.getIdpab()) {
				lista_update.set(contador,pabellonToString(pab));
			}
			contador++;
		}
		EscribirArchivo(lista_update,file);
	}

	@Override
	public void deletePabellon(Pabellon pab) throws IOException {
		file = new File(PropertiesUtil.getPathFileString("pabellon"));
		Scanner scan = new Scanner(file);
		String straux[] = null;
		List<String> lista_delete = new ArrayList<>();
		int contador = 0;
		while(scan.hasNext()){
			lista_delete.add(scan.nextLine());
			straux = lista_delete.get(contador).split(";");
			if(Integer.parseInt(straux[0]) == pab.getIdpab()) {
				lista_delete.remove(contador);
			}
			contador++;
		}
		EscribirArchivo(lista_delete,file);
	}

	
	@Override
	public List<Pabellon> getAllPabellon() throws IOException {
		file = new File(PropertiesUtil.getPathFileString("pabellon"));
		List<Pabellon> list_pabellones = new ArrayList<Pabellon>();
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			list_pabellones.add(StringToPabellon(scan.nextLine()));
		}
		return list_pabellones;
	}
	
	
	private String pabellonToString(Pabellon pab){
		return pab.getIdpab()+";"+pab.getNombre()+";"+pab.getDireccion()+";"+pab.getTamanio();
	}
	private Pabellon StringToPabellon(String strpabellon){
		String[] straux = strpabellon.split(";");
		Pabellon pab = new Pabellon();
		pab.setIdpab(Integer.valueOf(straux[0]));
		pab.setNombre(straux[1]);
		pab.setDireccion(straux[2]);
		pab.setTamanio(Double.valueOf(straux[3]));
		return pab;
		
	}
	private void EscribirArchivo(List<String> list_p,File file) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		for (String s: list_p) {
			pw.println(s);
		}
		pw.close();
	}

}
