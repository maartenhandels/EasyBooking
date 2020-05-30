package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import externalServices.Flight_parameters;
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
import server.LD.Usuario_Pago;
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
	public String registroUsuario(String nombre, String apellido, String email, String dni, String aero_nombre) {
		
		System.out.println("Entra en registroUsuario de la fachada");
		String contrasenya = null;
		
		try 
		{
			System.out.println("Entro en el try de registro");
			contrasenya = servAuth.registroUsuario(nombre, apellido, email, dni, aero_nombre);
			
		} catch (RemoteException e) 
		{
			
			System.err.println("No se ha podido registrar al usuario : " + e.getMessage());
		}
		
		return contrasenya;
	}

	@Override
	public UsuarioDTO iniciarSesion(String email, String contrasenya) {
		
		Usuario usuario = new Usuario();
		UsuarioDTO usuarioDTO = null;
		
		System.out.println("Llega a la fachada de inicio sesion");
		try 
		{
			usuario = servAuth.iniciarSesion(email, contrasenya);
			
		} catch (RemoteException e) {
			
			System.err.println("No se ha podido inicar sesion : " + e.getMessage());
		}
		
		if(usuario != null)
		{
			usuarioDTO = usAssem.assembleTousuarioDTO_Objeto(usuario);
		}
		
		return usuarioDTO;
	}

	@Override
	public void cerrarSesion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTO> getUsuariosAuth() 
	{
		List <Usuario> us = servAuth.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO_Lista(us);
		
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
	public String make_Payment(String email, double total_amount, String concept) throws RemoteException 
	{
		Usuario_Pago usuario_pago = new Usuario_Pago(email, total_amount, concept);
		return servPago.make_Payment(usuario_pago);
	}
	
	@Override
	public boolean update_currency(String email, float currency)  throws RemoteException 
	{
		Usuario_Pago usuario_pago = new Usuario_Pago(email, currency);
		System.out.println("Entro en la fachada de update currency");
		return servPago.update_currency(usuario_pago);
		
	}
	
	@Override
	public boolean create_User_Pago(String name, String lastname, String email, float currency) throws RemoteException 
	{
		Usuario_Pago usuario_pago = new Usuario_Pago(name, lastname, email, currency);
		return servPago.create_User_Pago(usuario_pago);
	}

	@Override
	public List<UsuarioDTO> getUsuariosPago() throws RemoteException
	{
		List <Usuario> us = servPago.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO_Lista(us);
			
		return usuarioDTO;
	}

	@Override
	public ArrayList<VueloDTO> getVuelosPago() throws RemoteException
	{
		
		ArrayList <Vuelo> vu = servPago.getVuelos();
		ArrayList<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}
	
	
	
	
	
	// PARTE FACHADA AERO
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter_0 (String origen) 
	{
		Flight_parameters parametros= new Flight_parameters(origen);
		ArrayList<VueloDTO> vuelosDTO;
		
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(parametros);
		
		if(vuelos.size()>0) {
			vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		}else {
			vuelosDTO = new ArrayList<VueloDTO>();
		}
		
		
		return vuelosDTO;
		
	}
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter_1 (String origen, String destino) 
	{
		Flight_parameters parametros= new Flight_parameters(origen, destino);
		ArrayList<VueloDTO> vuelosDTO;
		
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(parametros);
		
		if(vuelos.size()>0) {
			vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		}else {
			vuelosDTO = new ArrayList<VueloDTO>();
		}
		
		return vuelosDTO;
		
	}
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter_2 (String origen, String destino, int asientos) 
	{
		Flight_parameters parametros= new Flight_parameters(origen, destino, asientos);
		ArrayList<VueloDTO> vuelosDTO;
		
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(parametros);
		
		if(vuelos.size()>0) {
			vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		}else {
			vuelosDTO = new ArrayList<VueloDTO>();
		}
		
		return vuelosDTO;
		
	}
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter_3 (String origen, String destino, int asientos, double precio) 
	{
		Flight_parameters parametros= new Flight_parameters(origen, destino, asientos, precio);
		ArrayList<VueloDTO> vuelosDTO;
		
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(parametros);
		
		if(vuelos.size()>0) {
			vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		}else {
			vuelosDTO = new ArrayList<VueloDTO>();
		}
		
		return vuelosDTO;
		
	}
	
	@Override
	public ArrayList<VueloDTO> search_flights_with_filter_4 (String origen, String destino, int asientos, double precio, String fecha) 
	{
		
		// String fecha_String = fecha.toString();
		
		Flight_parameters parametros= new Flight_parameters(origen, destino, asientos, precio, fecha);
		ArrayList<VueloDTO> vuelosDTO;
		
		ArrayList<Vuelo> vuelos = servVuelo.search_flights_with_filter(parametros);
		
		if(vuelos.size()>0) {
			vuelosDTO= vuAssem.assembleTovueloDTO(vuelos);
		}else {
			vuelosDTO = new ArrayList<VueloDTO>();
		}
		
		return vuelosDTO;
		
	}
	
	@Override
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida) 
	{
		//Aqui creo que tendriamos que llamar a la clase de LN que haga esta funcionalidad.
		servVuelo.aplicarFiltros(aero_origen, aero_dest, num_pasajeros, precio, salida);
	}
	
	@Override
	public void createReserva (String cod_reserva, String cod_pago)
	{
		servVuelo.createReserva(cod_reserva, cod_pago);
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
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO_Lista(us);
			
		return usuarioDTO;
		
	}



}
