package server.Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;

public interface itfFachadaPago extends Remote {

	public List <UsuarioDTO> getUsuarios() throws RemoteException;
	public List<VueloDTO> getVuelos() throws RemoteException;
	public void realizarPago(double precio, String cod_reserva, String email) throws RemoteException;
}
