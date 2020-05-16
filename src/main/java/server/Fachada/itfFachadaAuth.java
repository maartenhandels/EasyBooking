package server.Fachada;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public interface itfFachadaAuth {

	
	public List <UsuarioDTO> getUsuarios();
	public void registroUs(String nombre, String email,String contranenya);
	public Usuario crearUsuario(String nombre, String apellido, String email,String contranenya, String dni, Aeropuerto aero, boolean aut, boolean pago);
	public void iniciarSesion (String email, String contrasenya);
	public void cerrarSesion ();
	
}
