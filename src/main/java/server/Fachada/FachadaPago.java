package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.AppService.AppServicePago;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.DTO.VueloAssembler;
import server.DTO.VueloDTO;
import server.LD.Usuario;
import server.LD.Vuelo;


public class FachadaPago extends UnicastRemoteObject implements itfFachadaPago {

	
	
	private static final long serialVersionUD = 1L;
	
	private AppServicePago servPago;
	
	UsuarioAssembler usAssem = new UsuarioAssembler();
	VueloAssembler vuAssem = new VueloAssembler();
	
	
	
	public FachadaPago() throws RemoteException {
		super();
		// servPago = new AppServicePago();
	}


	@Override
	public void realizarPago(double precio, String cod_reserva, String email) throws RemoteException {
		// TODO Auto-generated method stub
		servPago.realizarPago(precio, cod_reserva, email);
	}

	@Override
	public List<UsuarioDTO> getUsuarios() throws RemoteException
	{
		List <Usuario> us = servPago.getUsuarios();
		
		List<UsuarioDTO> usuarioDTO= usAssem.assembleTousuarioDTO(us);
			
		return usuarioDTO;
	}

	@Override
	public List<VueloDTO> getVuelos() throws RemoteException
	{
		
		List <Vuelo> vu = servPago.getVuelos();
		
		List<VueloDTO> vueloDTO= vuAssem.assembleTovueloDTO(vu);
			
		return vueloDTO;
	}

}
