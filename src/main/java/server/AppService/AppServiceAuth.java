package server.AppService;

import java.rmi.RemoteException;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Usuario;

public class AppServiceAuth {
	
	private Gateway gateway;

	public void registroUs(String nombre, String email,String contranenya) throws RemoteException
	{
		
	}
	public void iniciarSesion (String email, String contrasenya)throws RemoteException
	{
		
	}
	public void cerrarSesion ()throws RemoteException
	{
		
	}
	public List <Usuario> getUsuarios()
	{
		gateway.getUsuarios();
		return null;
		
	}
}
