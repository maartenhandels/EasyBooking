package server.AppService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServiceVuelo {
	
	private Gateway gateway;
	
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada)
	{
		gateway.buscarVuelo(aero_origen, aero_dest, num_pasajeros, precio, salida, llegada);
	}
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada)
	{
		gateway.createReserva(aero_origen, aero_destino, pasajeros, salida, llegada);
	}
	public void eliminarReserva(String cod_reserva, String cod_pago)
	{
		gateway.eliminarReserva(cod_reserva, cod_pago);
	}
	
	public List <Usuario> getUsuarios()
	{
		return gateway.getUsuarios();
	}
	
	public List <Vuelo> getVuelos()
	{
		return gateway.getVuelos();
		
		
	}
}
