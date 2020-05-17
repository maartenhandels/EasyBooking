package server.DTO;

import java.util.ArrayList;
import java.util.List;

import server.LD.Usuario;


public class UsuarioAssembler 
{
	public List <UsuarioDTO> assembleTousuarioDTO(List<Usuario> usuarios)
	{
		List<UsuarioDTO> usuarioDTO = new ArrayList<>();
		for (Usuario u : usuarios)
		{
			UsuarioDTO usDTO = new UsuarioDTO(u.getEmail(), u.getNombre(), u.getApellido(), u.getDni());
			usuarioDTO.add(usDTO);
		}
		System.out.println("* Assembling usuarios to usuariosDTO ...");
		
		return usuarioDTO;
		
	}
	
	public List <Usuario> assembletoUsuario(List<UsuarioDTO> usuarioDTO)
	{
		List<Usuario> usuarios = new ArrayList<>();
		for (UsuarioDTO u : usuarioDTO)
		{
			Usuario us = new Usuario();
			us.setEmail(u.getEmail());
			us.setNombre(u.getNombre());
			us.setApellido(u.getApellido());
			us.setDni(u.getDni());
			usuarios.add(us);
		}
		System.out.println("* Assembling usuariosDTO to usuarios ...");
		
		return usuarios;
		
	}

}
