package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.AppService.AppServiceVuelo;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.DTO.VueloAssembler;
import server.DTO.VueloDTO;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class FachadaAero extends UnicastRemoteObject implements itfFachadaAero {

	AppServiceVuelo servVuelo;
	UsuarioAssembler usAssem = new UsuarioAssembler();
	VueloAssembler vuAssem = new VueloAssembler();
	
	protected FachadaAero() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada) 
	{
		servVuelo.buscarVuelo(aero_origen, aero_dest, num_pasajeros, precio, salida, llegada);
	}
	@Override
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada) 
	{
		//Aqui creo que tendriamos que llamar a la clase de LN que haga esta funcionalidad.
	}
	@Override
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada) 
	{
		servVuelo.createReserva(aero_origen, aero_destino, pasajeros, salida, llegada);
	}

	@Override
	public void eliminarReserva(String cod_reserva, String cod_pago) 
	{
		servVuelo.eliminarReserva(cod_reserva, cod_pago);
	}

	@Override
	public List<VueloDTO> getVuelos() 
	{
		
		List <Vuelo> vu = servVuelo.getVuelos();
		
		List<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}

	@Override
	public List<UsuarioDTO> getUsuarios() 
	{
		
		List <Usuario> us = servVuelo.getUsuarios();
			
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
		
	}
	
}
