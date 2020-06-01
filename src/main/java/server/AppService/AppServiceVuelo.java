package server.AppService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import externalServices.Flight_parameters;
import server.DAO.DAO;
import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Reserva;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServiceVuelo {
	
	private Gateway gateway = new Gateway();
	private DAO dao = new DAO();
	
	public ArrayList<Vuelo> search_flights_with_filter (Flight_parameters parametros) 
	{
		
		ArrayList<Vuelo> vuelos = gateway.search_flights_with_filter(parametros);
		
		for(Vuelo v:vuelos)
		{
			int aux = (int)(Math.random()*1000000);
			String codigo = "AERO-" + Integer.toString(aux);
			v.getAerolinea().setCodAerolinea(codigo);
			
			System.out.println("El codigo random es: " + codigo);
		}
		
		return vuelos;
	}
	public void createReserva(String cod_reserva, String cod_pago)
	{	
		cod_reserva = String.valueOf(Math.random()*6);	
		cod_pago = String.valueOf(Math.random()*6+6);
		
		Reserva reserva = new Reserva(cod_reserva, cod_pago);	
		dao.guardarElemento(reserva);
		
	}
	public void eliminarReserva(String cod_reserva, String cod_pago)
	{
		Reserva reserva = new Reserva(cod_reserva, cod_pago);	
		dao.eliminarObjeto(reserva);
	}
	
	public ArrayList <Vuelo> search_all_flights ()
	{
		
		System.out.println("Entro en el AppService de buscar vuelos...");
		ArrayList <Vuelo> vuelos = gateway.search_all_flights();
		
		for(Vuelo v:vuelos)
		{
			int aux = (int)(Math.random()*1000000);
			String codigo = "AERO-" + Integer.toString(aux);
			v.getAerolinea().setCodAerolinea(codigo);
			
		}
				
		return vuelos;
		
		
	}
}
