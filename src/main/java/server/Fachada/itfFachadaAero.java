package server.Fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;

public interface itfFachadaAero {

	
	public List <VueloDTO> getVuelos();
	public List <UsuarioDTO> getUsuarios();
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada);
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida);
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada);
	public void eliminarReserva(String cod_reserva, String cod_pago);
	
}
