package server.Gateway;

import java.util.List;

import server.DTO.UsuarioDTO;

public interface itfGateway 
{
	public List <UsuarioDTO> getUsuarios();
}
