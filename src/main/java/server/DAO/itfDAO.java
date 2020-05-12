package server.DAO;

import java.util.ArrayList;

public interface itfDAO {
	
	public <T> boolean guardarElemto(T a);
	public <T> boolean guardarVariosElemtos(ArrayList<T> a);
	public <T> boolean eliminarObjeto(T a);
	public void cerrarBD();
	

}
