package server.AppService;

import java.rmi.RemoteException;
import java.util.List;

import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Usuario;

public class AppServiceAuth {
	
	private Gateway gateway;
	
	private UsuarioAssembler listaUs;
	private List<UsuarioDTO> listaUsDTO;
	
	public void registroUs(String nombre, String email,String contranenya) throws RemoteException
	{
		
	}
	public void iniciarSesion (String email, String contrasenya)throws RemoteException
	{
		gateway.log_in(email, contrasenya);
	}
	public void cerrarSesion (String email)throws RemoteException
	{
		gateway.log_out(email);
	}
	public List <Usuario> getUsuarios()
	{
		return listaUs.assembletoUsuario(listaUsDTO); //ya se q no es así pero creo que en algun momento hay que assemble 
		
		
	}
}
