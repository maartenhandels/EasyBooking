package server.Gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public interface itfGateway 
{
	public List <Usuario> getUsuarios();
	public List <Vuelo> getVuelos();
	
	
	public void realizarPago (double precio, String cod_reserva, String email);
	
	public void createReserva (String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada);
	public void eliminarReserva (String cod_reserva, String cod_pago);
	
	// Servicio externo - Aerolinea
	public void buscarVuelo (String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada);
	//Esto equivale a aplicar filtros
	public List <Vuelo> search_flights (String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida);
	
	// Servicio externo - Pago
	public String make_Payment (String email, float cant_total, String concepto);
	public String create_User_Pago (Usuario us, float divisa);
	public boolean update_currency (String email, float divisa);
	
	// Servicio externo - Autenticacion
	public boolean log_in (String email, String password);
	public boolean log_out (String email);
	public String create_User_Auth (String nombre, String apellido, String email);
	public boolean change_password (String email, String old_password, String new_password);
	public boolean delete_user (String email, String password);
	
}
