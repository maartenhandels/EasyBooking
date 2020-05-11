package server.Gateway;

import java.util.List;

import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Usuario;

public class Gateway implements itfGateway
{

	@Override
	public List<UsuarioDTO> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VueloDTO> getVuelos() {
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

}
