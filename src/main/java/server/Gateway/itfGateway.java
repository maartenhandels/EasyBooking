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
	//Esto equivale a aplicar filtros
	public ArrayList <Vuelo> search_all_flights ();
	public List <Vuelo> search_flights_with_filter (String aero_origen, String aero_dest);
	
	// Servicio externo - Pago
	public String make_Payment (String email, float cant_total, String concepto);
	public boolean create_User_Pago (Usuario us, float divisa);
	public boolean update_currency (String email, float divisa);
	
	// Servicio externo - Autenticacion
	public boolean log_in (String email, String password);
	public String create_User_Auth (String nombre, String apellido, String email);
	public boolean change_password (String email, String old_password, String new_password);
	public boolean delete_user (String email, String password);
	
}
