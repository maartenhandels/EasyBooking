package server.Fachada;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;

public interface itfFachadaPago {

	public List <UsuarioDTO> getUsuarios();
	public List<VueloDTO> getVuelos();
	public void realizarPago(double precio, String cod_reserva, String email);
}
