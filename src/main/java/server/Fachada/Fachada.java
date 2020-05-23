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
//	public String registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero) 
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
	public void iniciarSesion(String email, String contrasenya) {
		
		System.out.println("Llega a la fachada de inicio sesion");
		try 
		{
			servAuth.iniciarSesion(email, contrasenya);
			
		} catch (RemoteException e) {
			
			System.err.println("No se ha podido inicar sesion : " + e.getMessage());
		}
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
	public boolean eliminarUsuario(String email, String contrasenya) 
	{
		return servAuth.eliminarUsuario(email, contrasenya);
		
	}
	
	@Override
	public boolean cambiarContrasenya(String email, String contrasenya_antigua, String contrasenya_nueva) 
	{
		return servAuth.cambiarContrasenya(email, contrasenya_antigua,contrasenya_nueva );
		
	}
	
	
	// PARTE FACHADA PAGO
	
	@Override
	public void realizarPago(double precio, String cod_reserva, String email) throws RemoteException {
		// TODO Auto-generated method stub
		servPago.realizarPago(precio, cod_reserva, email);
	}

	@Override
	public List<UsuarioDTO> getUsuariosPago() throws RemoteException
	{
		List <Usuario> us = servPago.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
	}

	@Override
	public List<VueloDTO> getVuelosPago() throws RemoteException
	{
		
		List <Vuelo> vu = servPago.getVuelos();
		List<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}
	
	
	
	// PARTE FACHADA AERO
	
	@Override
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada) 
	{
		servVuelo.buscarVuelo(aero_origen, aero_dest, num_pasajeros, precio, salida, llegada);
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
	public List<VueloDTO> getVuelosAero() 
	{
		
		List <Vuelo> vu = servVuelo.getVuelos();
		List<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}

	@Override
	public List<UsuarioDTO> getUsuariosAero() 
	{
		
		List <Usuario> us = servVuelo.getUsuarios();
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
		
	}

}
