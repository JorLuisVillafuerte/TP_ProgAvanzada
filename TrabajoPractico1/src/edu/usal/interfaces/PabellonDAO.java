package edu.usal.interfaces;
import edu.usal.dto.*;
import java.util.*;
import java.io.*;
public interface PabellonDAO {
	
	public void addPabellon(Pabellon pab) throws IOException;
	public void updatePabellon(Pabellon pab)throws IOException;
	public void deletePabellon(Pabellon pab) throws IOException;
	public List<Pabellon> getAllPabellon() throws IOException;
}
