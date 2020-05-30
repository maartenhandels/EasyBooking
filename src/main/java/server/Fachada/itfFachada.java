package server.Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import externalServices.Flight_parameters;
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
	public String registroUsuario(String nombre, String apellido, String email, String dni, String aero_nombre) throws RemoteException;
	public boolean change_password (String email, String old_password, String new_password)throws RemoteException;
	public boolean eliminarUsuario(String email, String password)throws RemoteException;
	public UsuarioDTO iniciarSesion (String email, String password)throws RemoteException;
	public void cerrarSesion ()throws RemoteException;
	
	// Parte Fachada Pago
	public List <UsuarioDTO> getUsuariosPago() throws RemoteException;
	public List<VueloDTO> getVuelosPago() throws RemoteException;
	public String make_Payment(String email, double total_amount, String concept, VueloDTO vuelo, UsuarioDTO usuario) throws RemoteException;
	public boolean update_currency(String email, float currency) throws RemoteException;
	public boolean create_User_Pago (String name, String lastname, String email, float currency) throws RemoteException;
	
	// Parte Fachada Aero
	public ArrayList <VueloDTO> search_all_flights () throws RemoteException;
	public List <UsuarioDTO> getUsuariosAero() throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter_0(String origen)throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter_1(String origen, String destino)throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter_2(String origen, String destino, int asientos)throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter_3(String origen, String destino, int asientos, double precio)throws RemoteException;
	public ArrayList<VueloDTO> search_flights_with_filter_4(String origen, String destino, int asientos, double precio, String fecha)throws RemoteException;
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida)throws RemoteException;
	public void createReserva (String cod_reserva, String cod_pago)throws RemoteException;
	public void eliminarReserva(String cod_reserva, String cod_pago)throws RemoteException;
	
}
