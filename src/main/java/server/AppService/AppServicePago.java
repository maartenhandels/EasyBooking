package server.AppService;

import java.util.List;

import server.Gateway.Gateway;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServicePago {

	private Gateway gateway;
	
	public void realizarPago(double precio, String cod_reserva, String email) 
	{
		gateway.realizarPago(precio, cod_reserva, email);
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