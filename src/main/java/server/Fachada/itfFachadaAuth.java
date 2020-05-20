package server.Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public interface itfFachadaAuth extends Remote{

	
	public List <UsuarioDTO> getUsuarios() throws RemoteException;
	public String registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero)throws RemoteException;
	public boolean cambiarContrasenya(String email, String contrasenya_antigua, String contrasenya_nueva)throws RemoteException;
	public boolean eliminarUsuario(String email, String contrasenya)throws RemoteException;
	public void iniciarSesion (String email, String contrasenya)throws RemoteException;
	public void cerrarSesion ()throws RemoteException;
	
}
