package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.AppService.AppServiceAuth;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public class FachadaAuth extends UnicastRemoteObject implements itfFachadaAuth {

	AppServiceAuth servAuth;
	UsuarioAssembler usAssem = new UsuarioAssembler();
	
	public FachadaAuth() throws RemoteException {
		
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero) {
		
		System.out.println("Entra en la Fachada");
		
		String contrasenya = "";
		
		try 
		{
			contrasenya = servAuth.registroUsuario(nombre, apellido, email, dni, aero);
			
		} catch (RemoteException e) {
			
			System.err.println("No se ha podido registrar al usuario : " + e.getMessage());
		}
		
		return contrasenya;
	}

	@Override
	public void iniciarSesion(String email, String contrasenya) {
		
		System.out.println("Llega a la fachada");
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
	public List<UsuarioDTO> getUsuarios() 
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

}
