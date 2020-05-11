package server.Fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.AppService.AppServicePago;

public class FachadaPago extends UnicastRemoteObject implements itfFachadaPago{

	private static final long serialVersionUD = 1L;
	private AppServicePago servPago;
	
	protected FachadaPago() throws RemoteException {
		super();
		servPago = new AppServicePago();
	}

	@Override
	public void realizarPago(double precio, String cod_reserva, String email) {
		// TODO Auto-generated method stub
		servPago.realizarPago(precio, cod_reserva, email);
	}

}
