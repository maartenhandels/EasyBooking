package client.Controller;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.LP.InicioSesion_Registro;
import client.ServiceLocator.ServiceLocator;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.Fachada.itfFachada;
import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class Controller {

	
	private ServiceLocator rsl = null;
	private itfFachada fachada;
	
	
	
	public Controller(String [] args) throws RemoteException
	{
		rsl = new ServiceLocator();
		rsl.setService(args);
		fachada = rsl.getService();
		
		InicioSesion_Registro frame = new InicioSesion_Registro(this);
		frame.setVisible(true);
	}

	
	public String registroUsuario(String nombre, String apellido, String email, String dni, String aero_nombre) throws RemoteException
	{
		String contrasenya = null;

		contrasenya = fachada.registroUsuario(nombre, apellido, email, dni, aero_nombre);
		
		return contrasenya;
	}
	
	public UsuarioDTO iniciarSesion (String email, String password) throws RemoteException
	{
		boolean inicioSesion = false;
		UsuarioDTO usuario = null;
		
		System.out.println("Llega al controller de Iniciar Sesion");
		usuario = fachada.iniciarSesion(email, password);
		
		return usuario;
	}
	
	public ArrayList<VueloDTO> getAllFlights() throws RemoteException{
		
		System.out.println("Entro en el controler de buscar vuelos...");
		ArrayList<VueloDTO> vuelos = new ArrayList<VueloDTO>();
		
		
		try {
			vuelos = fachada.search_all_flights();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("El aeropuerto de salida del primer vuelo en LP es: "+ 
				vuelos.get(0).getAeropuertoDestino().getNombre());
			
		
 		
		System.out.println("Voy a salir del controler de buscar vuelos...");
		
		return vuelos;
	}
	
	public ArrayList<VueloDTO> search_flights_with_filter_0(String origen) throws RemoteException
	{
		
		// System.out.println("El aeropuerto de llegada de los filtros en el controller es: " + parametros.getAirport_arrival_name());
		ArrayList<VueloDTO> vuelos = fachada.search_flights_with_filter_0(origen);
		
		return vuelos;
	}
	
	public ArrayList<VueloDTO> search_flights_with_filter_1(String origen, String destino) throws RemoteException
	{
		
		// System.out.println("El aeropuerto de llegada de los filtros en el controller es: " + parametros.getAirport_arrival_name());
		ArrayList<VueloDTO> vuelos = fachada.search_flights_with_filter_1(origen, destino);
		
		return vuelos;
	}
	
	public ArrayList<VueloDTO> search_flights_with_filter_2(String origen, String destino, int asientos) throws RemoteException
	{
		
		// System.out.println("El aeropuerto de llegada de los filtros en el controller es: " + parametros.getAirport_arrival_name());
		ArrayList<VueloDTO> vuelos = fachada.search_flights_with_filter_2(origen, destino, asientos);
		
		return vuelos;
	}
	
	public ArrayList<VueloDTO> search_flights_with_filter_3(String origen, String destino, int asientos, double precio) throws RemoteException
	{
		
		 ArrayList<VueloDTO> vuelos = fachada.search_flights_with_filter_3(origen, destino, asientos, precio);
		
		return vuelos;
	}
	
	public ArrayList<VueloDTO> search_flights_with_filter_4(String origen, String destino, int asientos, double precio, String fecha) throws RemoteException
	{
		
		 ArrayList<VueloDTO> vuelos = fachada.search_flights_with_filter_4(origen, destino, asientos, precio, fecha);
		
		return vuelos;
	}
	
	public boolean eliminarUsuario(String email, String password) throws RemoteException
	{
		return fachada.eliminarUsuario(email, password);
	}
	
	public boolean change_password (String email, String old_password, String new_password) throws RemoteException
	{
		System.out.println("Entro en el controller de change password");
		return fachada.change_password(email, old_password, new_password);
	}
	/**
	 * Este metodo deberia tener el conjunto de filtros y aplicarlos a la lista de vuelos que conseguimos con buscarVuelo. Realmente este metodo no tiene
	 * que utilizar servicios externos, porque aplicamos los filtros sobre la lista que ya hemos recogido. Asi que no tendra que pasar mas alla del servicelocator
	 * @param aero_origen
	 * @param aero_dest
	 * @param num_pasajeros
	 * @param precio
	 * @param salida
	 * @param llegada
	 * @throws RemoteException 
	 */
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida) throws RemoteException 
	{
		fachada.aplicarFiltro(aero_origen, aero_dest, num_pasajeros, precio, salida);
	}
	
	public void createReserva (String cod_reserva, String cod_pago)throws RemoteException
	{
		fachada.createReserva(cod_reserva, cod_pago);
	}
	
	public void eliminarReserva(String cod_reserva, String cod_pago) throws RemoteException
	{
		fachada.eliminarReserva(cod_reserva, cod_pago);
	}
	
	public String  make_Payment(String email, double total_amount, String concept, VueloDTO vuelo, UsuarioDTO usuario) throws RemoteException
	{
		return fachada.make_Payment(email, total_amount, concept, vuelo, usuario);
	}
	
	public boolean update_currency(String email, float currency)throws RemoteException
	{
		System.out.println("Entro en el controller de update_currency");
		return fachada.update_currency(email, currency);
	}
	public boolean create_User_Pago (String name, String lastname, String email, float currency)throws RemoteException
	{
		return fachada.create_User_Pago(name, lastname, email, currency);
	}
	public void cerrarSesion ()
	{

	}
}
