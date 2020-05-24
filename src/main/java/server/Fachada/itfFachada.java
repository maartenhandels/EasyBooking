package server.Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public interface itfFachada extends Remote{

	// Parte Fachada Auth
	public List <UsuarioDTO> getUsuariosAuth() throws RemoteException;
//	public String registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero)throws RemoteException;
	public String registroUsuario(String nombre, String apellido, String email) throws RemoteException;
	public boolean change_password (String email, String old_password, String new_password)throws RemoteException;
	public boolean eliminarUsuario(String email, String password)throws RemoteException;
	public boolean iniciarSesion (String email, String password)throws RemoteException;
	public void cerrarSesion ()throws RemoteException;
	
	// Parte Fachada Pago
	public List <UsuarioDTO> getUsuariosPago() throws RemoteException;
	public List<VueloDTO> getVuelosPago() throws RemoteException;
	public String realizarPago(String email, float cant_total, String concepto) throws RemoteException;
	public void actualizarSaldo(String email, float divisa) throws RemoteException;
	public String create_User_Pago (Usuario us, float divisa) throws RemoteException;
	
	// Parte Fachada Aero
	public ArrayList <VueloDTO> search_all_flights () throws RemoteException;
	public List <UsuarioDTO> getUsuariosAero() throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter(String aero_origen, String aero_dest)throws RemoteException;
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida)throws RemoteException;
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada)throws RemoteException;
	public void eliminarReserva(String cod_reserva, String cod_pago)throws RemoteException;
	
}
