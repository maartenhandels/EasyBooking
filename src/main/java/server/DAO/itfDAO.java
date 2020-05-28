package server.DAO;

import java.util.ArrayList;

import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Reserva;
import server.LD.Usuario;
import server.LD.Vuelo;

public interface itfDAO {
	
	public <T> boolean guardarElemto(T a);
	public <T> boolean guardarVariosElemtos(ArrayList<T> a);
	
	public <T> boolean eliminarObjeto(T a);
	
	public ArrayList<Aeropuerto> LeerAeropuertos();
	public ArrayList<Vuelo> LeerVuelos();
	public ArrayList<Usuario> LeerUsuarios();
	public ArrayList<Pasajero> LeerPasajeros();
	public ArrayList<Reserva> LeerReservas();
	
	public String buscarNombreUsuario(Usuario user);
	
	public void cerrarBD();
	

}
