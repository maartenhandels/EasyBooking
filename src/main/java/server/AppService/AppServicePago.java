package server.AppService;

import java.util.ArrayList;
import java.util.List;

import server.DAO.DAO;
import server.Gateway.Gateway;
import server.LD.Reserva;
import server.LD.Usuario;
import server.LD.Usuario_Pago;
import server.LD.Vuelo;

public class AppServicePago {

	private Gateway gateway = new Gateway();
	private DAO dao = new DAO();
	
	public String make_Payment(Usuario_Pago usuario_pago, Vuelo vuelo, Usuario usuario) 
	{
		String reciboPago = gateway.make_Payment(usuario_pago);
		
		if(reciboPago != null) {
			
			ArrayList<Reserva> reservas = dao.LeerReservas();
			
			String codReserva;
			
			if(reservas.size()>0) {
				int numReserva = reservas.size() + 1;
				codReserva = "RES-" + numReserva;
			}else {
				codReserva = "RES-1";
			}
						
			Usuario usuario_aux = null;
			Reserva reserva = new Reserva(usuario_aux, codReserva, reciboPago, vuelo);
			
			dao.guardarElemto(reserva);
			
		}
		
		return reciboPago;
	}
	
	public List <Usuario> getUsuarios()
	{
		return null;
	}
	
	public ArrayList <Vuelo> getVuelos()
	{
		return null;
	}
	
	public boolean update_currency(Usuario_Pago usuario_pago) 
	{
		return gateway.update_currency(usuario_pago);
	}
	
	public boolean create_User_Pago (Usuario_Pago us)
	{
		return gateway.create_User_Pago(us);
	}
}