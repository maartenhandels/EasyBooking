package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import server.AppService.AppServiceVuelo;
import server.LD.Pasajero;

public class FachadaAero extends UnicastRemoteObject implements itfFachadaAero {

	private AppServiceVuelo servVuelo;
	
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
	
}
