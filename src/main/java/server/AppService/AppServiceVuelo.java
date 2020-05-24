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
	
	private Gateway gateway = new Gateway();
	
	public ArrayList<Vuelo> search_flights_with_filter (String aero_origen, String aero_dest) 
	{
		ArrayList<Vuelo> vuelos = gateway.search_flights_with_filter(aero_origen, aero_dest);
		
		return vuelos;
	}
	public void aplicarFiltros(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida)
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
		return null;
	}
	
	public ArrayList <Vuelo> search_all_flights ()
	{
		
		System.out.println("Entro en el AppService de buscar vuelos...");
		ArrayList <Vuelo> vuelos = gateway.search_all_flights();
		
		System.out.println("Voy a salir del AppService de buscar vuelos...");
		
		return vuelos;
		
		
	}
}
