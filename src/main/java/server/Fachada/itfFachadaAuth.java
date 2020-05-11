package server.Fachada;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;

public interface itfFachadaAuth {

	
	public List <UsuarioDTO> getUsuarios();
	public void registroUs(String nombre, String email,String contranenya);
	public void iniciarSesion (String email, String contrasenya);
	public void cerrarSesion ();
	
}
