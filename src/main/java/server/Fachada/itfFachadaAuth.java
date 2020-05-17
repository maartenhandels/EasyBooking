package server.Fachada;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public interface itfFachadaAuth {

	
	public List <UsuarioDTO> getUsuarios();
	public void registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero);
	public boolean cambiarContrasenya(String email, String contrasenya_antigua, String contrasenya_nueva);
	public boolean eliminarUsuario(String email, String contrasenya);
	public void iniciarSesion (String email, String contrasenya);
	public void cerrarSesion ();
	
}
