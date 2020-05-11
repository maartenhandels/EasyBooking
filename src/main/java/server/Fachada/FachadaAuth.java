package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.AppService.AppServiceAuth;

public class FachadaAuth extends UnicastRemoteObject implements itfFachadaAuth{

	AppServiceAuth servAuth;
	
	protected FachadaAuth() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registroUs(String nombre, String email, String contranenya) {
		// TODO Auto-generated method stub
		try 
		{
			servAuth.registroUs(nombre, email, contranenya);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido registrar al usuario : " + e.getMessage());
		}
	}

	@Override
	public void iniciarSesion(String email, String contrasenya) {
		// TODO Auto-generated method stub
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
	

}
