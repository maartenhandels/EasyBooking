package server.AppService;

import java.rmi.RemoteException;
import java.util.List;

import server.DAO.DAO;
import server.DAO.itfDAO;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public class AppServiceAuth {
	
	private Gateway gateway = new Gateway();
	private DAO dao;
	
	public String registroUsuario(String nombre, String apellido, String email) throws RemoteException
	{
		System.out.println("Entra en el AppService - registro");
		
		String contrasenya = gateway.create_User_Auth(nombre, apellido, email);
		
		System.out.println("Pasa la llamada del gateway");
		
//		Usuario nuevo_usuario = new Usuario(email, nombre, apellido);
//		dao.guardarElemto(nuevo_usuario);
	
		
		return contrasenya;
		
	}
	
	public boolean iniciarSesion (String email, String password) throws RemoteException
	{
		System.out.println("Entra AppService - Inicio Sesion");
		boolean iniSesCorrecto = gateway.log_in(email, password);
		return iniSesCorrecto;
		
	}
	public void cerrarSesion (String email)throws RemoteException
	{
		
	}
	public List <Usuario> getUsuarios()
	{
		return null;
	}
	public boolean eliminarUsuario(String email, String password )
	{
		return gateway.delete_user(email, password);
		//FALTA ELIMINAR DE DAO
	}
	public boolean change_password (String email, String old_password, String new_password)
	{
		System.out.println("Entra AppService - Change password");
		return gateway.change_password(email, old_password, new_password);
		//FALTA CAMBIAR EN DAO
	}
}
