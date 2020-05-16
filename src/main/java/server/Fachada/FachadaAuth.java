package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.AppService.AppServiceAuth;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public class FachadaAuth extends UnicastRemoteObject implements itfFachadaAuth{

	AppServiceAuth servAuth;
	UsuarioAssembler usAssem = new UsuarioAssembler();
	
	protected FachadaAuth() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registroUs(String nombre, String email, String contranenya) {
		// TODO Auto-generated method stub
		try 
		{
			servAuth.registroUs(nombre, email,contranenya);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido registrar al usuario : " + e.getMessage());
		}
	}

	@Override
	public void iniciarSesion(String email, String contrasenya) {
		// TODO Auto-generated method stub
		System.out.println("Llega a la fachada");
		try 
		{
			servAuth.iniciarSesion(email, contrasenya);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido inicar sesion : " + e.getMessage());
		}
	}

	@Override
	public void cerrarSesion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<UsuarioDTO> getUsuarios() 
	{
		List <Usuario> us = servAuth.getUsuarios();
		
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
		
		return usuarioDTO;
	}

	@Override
	public Usuario crearUsuario(String nombre, String apellido, String email, String contrasenya, String dni,
			Aeropuerto aero, boolean aut, boolean pago) {
		
		Usuario user = new Usuario(nombre, apellido, email, contrasenya, dni, aero, aut, pago);
		
		servAuth.crearUsuario(user);
		return user;
	}
	

}
