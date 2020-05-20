package server.Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;

public interface itfFachadaAero extends Remote {

	
	public List <VueloDTO> getVuelos()throws RemoteException;
	public List <UsuarioDTO> getUsuarios()throws RemoteException;
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada)throws RemoteException;
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida)throws RemoteException;
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada)throws RemoteException;
	public void eliminarReserva(String cod_reserva, String cod_pago)throws RemoteException;
	
}
