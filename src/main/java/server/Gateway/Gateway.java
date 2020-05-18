package server.Gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import externalServices.Print;
import externalServices.RestClient;
import externalServices.RestClient_Unmarshalling;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class Gateway implements itfGateway
{
	String hostname = "192.168.6.31";
	String port_auth = "5000";
	String port_pay = "5001";
	String port_airlines = "5002";

	public void createConexion()
	{
		RestClient_Unmarshalling c1 = new RestClient_Unmarshalling(hostname, port_auth);

		try {
			c1.makeGetRequest("/");
			c1.makeGetRequest("/Authentication/Log_in");
			c1.makeGetRequest("/Authentication/Create_user");
			c1.makeGetRequest("/Authentication/Change_password");
			c1.makeGetRequest("/Authentication/Delete_user");
			
			// todo c1.makePostRequest("This is a client super complex message to send to
			// server");
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}

		
		RestClient_Unmarshalling c2 = new RestClient_Unmarshalling(hostname, port_pay);

		try {
			c2.makeGetRequest("/");
			c2.makeGetRequest("/Payments/Make_payment");
			c2.makeGetRequest("/Payments/Create_user");
			c2.makeGetRequest("/Payments/Update_currency");

			// todo c2.makePostRequest("This is a client super complex message to send to
			// server");
	
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}

		
		RestClient_Unmarshalling c3 = new RestClient_Unmarshalling(hostname, port_airlines);

		try {
			c3.makeGetRequest("/");
			c3.makeGetRequest("/Airlines/Search_Flights");
			
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}
	}
	
	@Override
	public List<Usuario> getUsuarios() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vuelo> getVuelos() 
	{
		RestClient<Vuelo> client = new RestClient<Vuelo>(args[0], args[1]);

		System.out.println("-------------------------------------------------------");
		System.out.println("Search flights Airlines Server test (GET) ");
		System.out.println("-------------------------------------------------------");

		String path = "/Airlines/Search_Flights";
		System.out.println("Trying GET at " + path + " (Test message)");
		System.out.println("CURL call: curl http://127.0.0.1:5000/Airlines/Search_Flights");

		try {
			client.simplePrint(client.makeGetRequest(client.createInvocationBuilder(path)));
		} 
		catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		return null;
	}

	@Override
	public String make_Payment(String email, float cant_total, String concepto) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create_User_Pago(Usuario us, float divisa) 
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
	    RestClient<Usuario> client = new RestClient<>(args[0], args[1]);
	    System.out.println("-------------------------------------------------------");
        System.out.println("Authentication Login Server test (POST)");
        System.out.println("-------------------------------------------------------");

        String path = "/Authentication/Log_in";
        System.out.println("Trying POST at " + path + " (Log in service)");
        System.out.println("CURL call: curl http://127.0.0.1:5000/Authentication/Log_in -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"password\":\"XXX\" }' -X POST -H \"Content-Type: application/json\" -v");

        Response response = null;
        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Usuario(email, password)

            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
        client.simplePrint(response);
        System.out.println("We obtain a false as the user has not been created");
		return false;
	}

	@Override
	public String create_User_Auth (String nombre, String apellido, String email) 
	{	
		System.out.println("Entra en el Gateway");
		String contrasenya = "";
		
		// Comunicarse con el servicio externo
		
		return contrasenya;
		
		
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
