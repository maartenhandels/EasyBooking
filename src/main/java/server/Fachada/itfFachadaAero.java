package server.Fachada;

import java.util.ArrayList;
import java.util.Date;

import server.LN.Pasajero;

public interface itfFachadaAero {

	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada);
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada);
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada);
	public void eliminarReserva(String cod_reserva, String cod_pago);
	
}
