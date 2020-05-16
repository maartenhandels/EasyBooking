package server.AppService;

import java.rmi.RemoteException;
import java.util.List;

import server.DAO.DAO;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Usuario;

public class AppServiceAuth {
	
	private Gateway gateway;
	private DAO dao;
	
	public void registroUs(String nombre, String email,String contranenya) throws RemoteException
	{
		gateway.registroUs(nombre, email, contranenya);
	}
	public void iniciarSesion (String email, String contrasenya)throws RemoteException
	{
		System.out.println("Llega al appservice");
		gateway.log_in(email, contrasenya);
	}
	public void cerrarSesion (String email)throws RemoteException
	{
		gateway.log_out(email);
	}
	public List <Usuario> getUsuarios()
	{
		return gateway.getUsuarios();
	}
	public void crearUsuario(Usuario us)
	{
		gateway.create_User(us);
		dao.guardarElemto(us);
	}
}
