package server.AppService;

import java.util.ArrayList;
import java.util.List;

import server.DAO.DAO;
import server.Gateway.Gateway;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServicePago {

	private Gateway gateway = new Gateway();
	private DAO dao;
	
	public String realizarPago(String email, Float cant_total, String concepto) 
	{
		return gateway.make_Payment(email, cant_total, concepto);
	}
	
	public List <Usuario> getUsuarios()
	{
		return null;
	}
	
	public ArrayList <Vuelo> getVuelos()
	{
		return null;
	}
	
	public boolean update_currency(String email, float divisa) 
	{
		System.out.println("Entro en el appService de change password");
		return gateway.update_currency(email, divisa);
	}
	
	public boolean create_User_Pago (Usuario us, float divisa)
	{
		return gateway.create_User_Pago(us, divisa);
	}
}