package server.Gateway;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;

public interface itfGateway 
{
	public List <UsuarioDTO> getUsuarios();
	public List <VueloDTO> getVuelos();
}
