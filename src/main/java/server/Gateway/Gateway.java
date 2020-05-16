package server.Gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class Gateway implements itfGateway
{

	@Override
	public List<Usuario> getUsuarios() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vuelo> getVuelos() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make_Payment(String email, float cant_total, String concepto) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create_User(Usuario us, float divisa) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update_currency(String email, float divisa) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean log_in(String email, String password) 
	{
		System.out.println("Llega al gateway");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String create_User(Usuario us) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean change_password(String email, String old_password, String new_password) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete_user(String email, String password) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean log_out(String email) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registroUs(String nombre, String email, String contranenya) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarPago(double precio, String cod_reserva, String email) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarReserva(String cod_reserva, String cod_pago) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vuelo> search_flights(String aero_origen, String aero_dest, int num_pasajeros, double precio,
			Date salida) {
		//devolvera lista de vuelos que cumplan con los filtros que enviemos
		return null;
	}

}
