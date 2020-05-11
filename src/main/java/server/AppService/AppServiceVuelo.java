package server.AppService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.Gateway.Gateway;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServiceVuelo {
	
	private Gateway gateway;
	
	public AppServiceVuelo()
	{
		
	}

	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada)
	{
		
	}
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada)
	{
		
	}
	public void eliminarReserva(String cod_reserva, String cod_pago)
	{
		
	}
	
	public List <Usuario> getUsuarios()
	{
		gateway.getUsuarios();
		return null;
		
	}
	
	public List <Vuelo> getVuelos()
	{
		gateway.getVuelos();
		return null;
		
	}
}
