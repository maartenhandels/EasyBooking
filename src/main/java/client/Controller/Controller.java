package client.Controller;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import client.ServiceLocator.ServiceLocator;
import server.LD.Aeropuerto;
import server.LD.Pasajero;

public class Controller {

	private ServiceLocator rsl = null;
	
	public Controller() throws RemoteException
	{
		rsl = new ServiceLocator();
		rsl.setService();
	}

	
	public void registroUs(String nombre, String email,String contranenya)
	{
		rsl.getServiceAuth().registroUs(nombre, email, contranenya);
	}
	public void iniciarSesion (String email, String contrasenya)
	{
		System.out.println("Llega al controller");
		rsl.getServiceAuth().iniciarSesion(email, contrasenya);
	}
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada)
	{
		rsl.getServiceAero().buscarVuelo(aero_origen, aero_dest, num_pasajeros, precio, salida, llegada);
	}
	
	public void nuevoUsuario(String nombre, String apellido, String email,String contranenya, String dni, Aeropuerto aero, boolean aut, boolean pago)
	{
		
	}
	public boolean eliminarUsuario(String email, String contrasenya)
	{
		return rsl.getServiceAuth().eliminarUsuario(email, contrasenya);
	}
	public boolean cambiarContrasenya(String email, String contrasenya_antigua, String contrasenya_nueva)
	{
		return rsl.getServiceAuth().cambiarContrasenya(email, contrasenya_antigua, contrasenya_nueva);
	}
	/**
	 * Este metodo deberia tener el conjunto de filtros y aplicarlos a la lista de vuelos que conseguimos con buscarVuelo. Realmente este metodo no tiene
	 * que utilizar servicios externos, porque aplicamos los filtros sobre la lista que ya hemos recogido. Asi que no tendra que pasar mas alla del servicelocator
	 * @param aero_origen
	 * @param aero_dest
	 * @param num_pasajeros
	 * @param precio
	 * @param salida
	 * @param llegada
	 */
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida) 
	{
		rsl.getServiceAero().aplicarFiltro(aero_origen, aero_dest, num_pasajeros, precio, salida);
	}
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada)
	{
		rsl.getServiceAero().createReserva(aero_origen, aero_destino, pasajeros, salida, llegada);
	}
	public void eliminarReserva(String cod_reserva, String cod_pago)
	{
		rsl.getServiceAero().eliminarReserva(cod_reserva, cod_pago);
	}
	public void realizarPago(double precio, String cod_reserva, String email)
	{
		rsl.getServicePago().realizarPago(precio, cod_reserva, email);
	}
	public void cerrarSesion ()
	{

	}
}
