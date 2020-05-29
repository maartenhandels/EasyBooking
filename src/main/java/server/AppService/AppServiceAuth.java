package server.AppService;

import java.rmi.RemoteException;
import java.util.ArrayList;
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
	private DAO dao = new DAO();
	
	public String registroUsuario(String nombre, String apellido, String email) throws RemoteException
	{
		System.out.println("Entra en el AppService - registro");
		
		String contrasenya = gateway.create_User_Auth(nombre, apellido, email);
		
		// String contrasenya = "HOLA";
		System.out.println("Pasa la llamada del gateway");
		
		Usuario nuevo_usuario = new Usuario(email, nombre, apellido);
		dao.guardarElemto(nuevo_usuario);
	
		
		return contrasenya;
		
	}
	
	public Usuario iniciarSesion (String email, String password) throws RemoteException
	{
		System.out.println("Entra AppService - Inicio Sesion");
		boolean iniSesCorrecto = gateway.log_in(email, password);
		
		Usuario usuario;
		
		//ESTO HE HECHO PERO NOSE SI HABRA QUE HACER ALGUNA BUSQUEDA ASI 
//		ArrayList<Usuario> lista = dao.LeerUsuarios();
//		Usuario usuario = null;
		
//		for(int i=0; i<lista.size(); i++)
//		{
//			if(usuario.getEmail().equals(lista.get(i).getEmail()))
//			{
//				usuario = new Usuario(email, password);
//			}
//			else
//			{
//				System.out.println("Este usuario no es correcto");
//				usuario = null;
//			}
//		}
		// DEBERIAMOS BUSCAR EN LA BASE DE DATOS EL USUARIO
		// DE MOMENTO CREAREMOS UN USUARIO CADA VEZ QUE SE LE LLAME
		if(iniSesCorrecto) {
			usuario = new Usuario(email, password);
//			String nombre = dao.buscarNombreUsuario(usuario);
			usuario = new Usuario("Manolo", "Lama", "manololama@gmail.com");
		}else {
			usuario = null;
		}
		
		//return nombre;
		return usuario;
		
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
		Usuario userBorrar =  new Usuario(email, password);
		
		dao.eliminarObjeto(userBorrar);
		
		return gateway.delete_user(email, password);
		
	}
	public boolean change_password (String email, String old_password, String new_password)
	{
		return gateway.change_password(email, old_password, new_password);
	}
}
