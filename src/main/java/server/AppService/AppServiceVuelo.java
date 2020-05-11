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
	private List<UsuarioDTO> listaUsDTO;
	
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
		gateway.getUsuarios();//es que aquí le estamos llamando a gateway que tiene usuarioDTO no usuario
		return null;
		
	}
	
	public List <Vuelo> getVuelos()
	{
		gateway.getVuelos();//lo mismo para vuelos 
		return null;
		
	}
}
