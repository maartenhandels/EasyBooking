package server.Gateway;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Usuario;
import server.LD.Vuelo;

public interface itfGateway 
{
	public List <UsuarioDTO> getUsuarios();
	public List <VueloDTO> getVuelos();
	
	//Servicio externo - aerolinea
	//public List <Vuelo> search_flights();
	
	//servicio externo - Pago
	public String make_Payment (String email, float cant_total, String concepto);
	public String create_User (Usuario us, float divisa);
	public boolean update_currency (String email, float divisa);
	
	//servicio externo - autenticacion
	public boolean log_in(String email, String password);
	public String create_User (Usuario us);
	public boolean change_password(String email, String old_password, String new_password);
	public boolean delete_user (String email, String password);
	
}
