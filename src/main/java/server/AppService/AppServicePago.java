package server.AppService;

import java.util.ArrayList;
import java.util.List;

import server.DAO.DAO;
import server.Gateway.Gateway;
import server.LD.Usuario;
import server.LD.Vuelo;

public class AppServicePago {

	private Gateway gateway = new Gateway();
//	private DAO dao = new DAO();
	
	public String make_Payment(String email, float total_amount, String concept) 
	{
		return gateway.make_Payment(email, total_amount, concept);
	}
	
	public List <Usuario> getUsuarios()
	{
		return null;
	}
	
	public ArrayList <Vuelo> getVuelos()
	{
		return null;
	}
	
	public boolean update_currency(String email, float currency) 
	{
		System.out.println("Entro en el appService de update currency");
		return gateway.update_currency(email, currency);
	}
	
	public boolean create_User_Pago (Usuario us, float currency)
	{
		return gateway.create_User_Pago(us, currency);
	}
}