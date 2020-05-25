package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.AppService.AppServiceAuth;
import server.AppService.AppServicePago;
import server.AppService.AppServiceVuelo;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.DTO.VueloAssembler;
import server.DTO.VueloDTO;
import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class Fachada extends UnicastRemoteObject implements itfFachada {

	
	private static final long serialVersionUID = 1L;
	
	private AppServiceAuth servAuth = new AppServiceAuth();
	private AppServicePago servPago = new AppServicePago();
	private AppServiceVuelo servVuelo = new AppServiceVuelo();
	
	private UsuarioAssembler usAssem = new UsuarioAssembler();
	private VueloAssembler vuAssem = new VueloAssembler();
	
	
	
	
	public Fachada() throws RemoteException {
		
		super();
		System.out.println("Llega al constructor de la Fachada");
		
	}
	
	
	
	// PARTE FACHADA AUTH

	@Override
	public String registroUsuario(String nombre, String apellido, String email) {
		
		System.out.println("Entra en registroUsuario de la fachada");
		
		String contrasenya = "";
		
		try 
		{
			System.out.println("Entro en el try de registro");
			contrasenya = servAuth.registroUsuario(nombre, apellido, email);
			
		} catch (RemoteException e) 
		{
			
			System.err.println("No se ha podido registrar al usuario : " + e.getMessage());
		}
		
		return contrasenya;
	}

	@Override
	public boolean iniciarSesion(String email, String contrasenya) {
		
		boolean inicioSesion = false; 
		
		System.out.println("Llega a la fachada de inicio sesion");
		try 
		{
			inicioSesion = servAuth.iniciarSesion(email, contrasenya);
			
		} catch (RemoteException e) {
			
			System.err.println("No se ha podido inicar sesion : " + e.getMessage());
		}
		
		return inicioSesion;
	}

	@Override
	public void cerrarSesion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTO> getUsuariosAuth() 
	{
		List <Usuario> us = servAuth.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
		
		return usuarioDTO;
	}

	@Override
	public boolean eliminarUsuario(String email, String password) 
	{
		return servAuth.eliminarUsuario(email, password);
		
	}
	
	@Override
	public boolean change_password (String email, String old_password, String new_password) 
	{
		System.out.println("Llega a la fachada de change password");
		return servAuth.change_password(email, old_password,new_password );
		
	}
	
	
	// PARTE FACHADA PAGO
	
	@Override
	public String realizarPago(String email, float cant_total, String concepto) throws RemoteException 
	{

		return servPago.realizarPago(email, cant_total, concepto);
	}

	@Override
	public List<UsuarioDTO> getUsuariosPago() throws RemoteException
	{
		List <Usuario> us = servPago.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
	}

	@Override
	public ArrayList<VueloDTO> getVuelosPago() throws RemoteException
	{
		
		ArrayList <Vuelo> vu = servPago.getVuelos();
		ArrayList<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}
	
	@Override
	public boolean update_currency(String email, float divisa)  throws RemoteException 
	{
		System.out.println("Entro en la fachada de change password");
		return servPago.update_currency(email, divisa);
		
	}
	
	@Override
	public boolean create_User_Pago(Usuario us, float divisa) throws RemoteException 
	{

		return servPago.create_User_Pago(us, divisa);
	}
	
	
	
	// PARTE FACHADA AERO
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter (String aero_origen, String aero_dest) 
	{
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(aero_origen, aero_dest);
		ArrayList<VueloDTO> vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		
		return vuelosDTO;
		
	}
	
	@Override
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida) 
	{
		//Aqui creo que tendriamos que llamar a la clase de LN que haga esta funcionalidad.
		servVuelo.aplicarFiltros(aero_origen, aero_dest, num_pasajeros, precio, salida);
	}
	
	@Override
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada) 
	{
		servVuelo.createReserva(aero_origen, aero_destino, pasajeros, salida, llegada);
	}

	@Override
	public void eliminarReserva(String cod_reserva, String cod_pago) 
	{
		servVuelo.eliminarReserva(cod_reserva, cod_pago);
	}

	@Override
	public ArrayList<VueloDTO> search_all_flights () 
	{
		System.out.println("Entro en la Fachada de buscar vuelos...");
		ArrayList <Vuelo> vuelos = servVuelo.search_all_flights ();
		
		System.out.println("El aeropuerto destino del primer vuelo en la fachada es: " + vuelos.get(0).getAeropuertoDestino().getNombre());
		
		ArrayList<VueloDTO> vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		
		System.out.println("Voy a salir de la Fachada de buscar vuelos...");
			
		return vuelosDTO;
	}

	@Override
	public List<UsuarioDTO> getUsuariosAero()
	{
		
		List <Usuario> us = servVuelo.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
		
	}



}
