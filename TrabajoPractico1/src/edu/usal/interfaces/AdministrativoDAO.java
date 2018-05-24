package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.dto.Administrativo;

public interface AdministrativoDAO {
	public void addAdministrativo(Administrativo adm) throws IOException;
	public void updateAdministrativo(Administrativo adm)throws IOException;
	public void deleteAdministrativo(Administrativo adm) throws IOException;
	public List<Administrativo> getAllAdmin() throws IOException;

}
