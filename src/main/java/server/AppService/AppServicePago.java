package server.AppService;

import java.util.List;

import server.Gateway.Gateway;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServicePago {

	private Gateway gateway;
	
	public void realizarPago(double precio, String cod_reserva, String email) {
		// TODO Auto-generated method stub
		
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