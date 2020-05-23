package server.Gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONObject;
import externalServices.Print;
import externalServices.RestClient;
import externalServices.RestClient_Unmarshalling;
import externalServices.Simple_pass_result;
import externalServices.Flight_parameters;
import externalServices.Flight_JSON;
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
	public String make_Payment(String email, float cant_total, String concepto) 
	{
		RestClient<Usuario> client = new RestClient<>(hostname, port_pay);
		System.out.println("-------------------------------------------------------");
        System.out.println("Make payment Server test (POST)");
        System.out.println("-------------------------------------------------------");

        String path = "/Payments/Make_payment";
        System.out.println("Trying POST at " + path );
        System.out.println("CURL call: curl http://127.0.0.1:5001/Payments/Make_payment -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"total_amount\":\"20.5\", \"concept\":\"Hello World Payment\" }' -X POST -H \"Content-Type: application/json\" -v");

        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Usuario(email, cant_total, concepto)
                    )
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }

        System.out.println("Note that we obtain a false result because the user does not exist in the Payments microservice");

		return null;
	}

	@Override
	public String create_User_Pago(Usuario us, float divisa) 
	{
		RestClient<Usuario> client = new RestClient<>(hostname, port_pay);
		System.out.println("-------------------------------------------------------");
        System.out.println("Create_user Server test (POST)");
        System.out.println("-------------------------------------------------------");

        String path = "/Payments/Create_user";
        System.out.println("Trying POST at " + path );
        System.out.println("CURL call: curl http://127.0.0.1:5001/Payments/Create_user -d '{\"name\":\"Inigo\", \"last_name\":\"Lopez-Gazpio\", \"email\":\"inigo.lopezgazpio@deusto.es\", \"currency\":\"20.5\"}' -X POST -H \"Content-Type: application/json\" -v");

        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Usuario(us,divisa)
                    )
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }

		return null;
	}

	@Override
	public boolean update_currency(String email, float divisa) 
	{
		RestClient<Usuario> client = new RestClient<>(hostname, port_pay);
		System.out.println("-------------------------------------------------------");
		System.out.println("Update currency Server test (POST)");
		System.out.println("-------------------------------------------------------");

		String path = "/Payments/Update_currency";
		System.out.println("Trying POST at " + path);
		System.out.println(
				"CURL call: curl http://127.0.0.1:5001/Payments/Update_currency -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"currency\":\"100\"}' -X PUT -H \"Content-Type: application/json\" -v");

		try {
			client.simplePrint(client.makePutRequest(client.createInvocationBuilder(path),
					new Usuario(email, divisa)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		return false;
	}

	@Override
	public boolean log_in(String email, String password) 
	{
	    RestClient<Usuario> client = new RestClient<>(hostname, port_auth);
	    System.out.println("-------------------------------------------------------");
        System.out.println("Authentication Login Server test (POST)");
        System.out.println("-------------------------------------------------------");

        String path = "/Authentication/Log_in";
        System.out.println("Trying POST at " + path + " (Log in service)");
        // System.out.println("CURL call: curl http://127.0.0.1:5000/Authentication/Log_in -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"password\":\"XXX\" }' -X POST -H \"Content-Type: application/json\" -v");

        String responseString = null;
        Response response = null;
        boolean operation_result = true;
        
        System.out.println("El email que se va a mandar es: " + email);
        System.out.println("El password que se va a mandar es: " + password);
        
        
        
        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path), new Usuario(email, password));
                      //   ).readEntity(String.class);
                            
            responseString =
                            client.makePostRequest(
                                    client.createInvocationBuilder(path) , new Usuario(email, password)
                               ).readEntity(String.class);
                        

                    JSONParser myParser = new JSONParser();
                    JSONObject myJsonObject = (JSONObject) myParser.parse(responseString);
                    operation_result = (boolean) myJsonObject.get("Result");

        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
        client.simplePrint(response);
        System.out.println("We obtain a false if the user has not been created");
        System.out.println("But the response is..." + operation_result);
        
        
		return operation_result;
	}

	@Override
	public String create_User_Auth (String nombre, String apellido, String email) 
	{	
		RestClient<Usuario> client = new RestClient<>(hostname, port_auth);
		System.out.println("Entra en el Gateway");
		String contrasenya = "";
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Authentication Create User Server test (POST)");
		System.out.println("-------------------------------------------------------");

		String path = "/Authentication/Create_user";
		System.out.println("Trying POST at " + path + " (Create user)");
		System.out.println(
				"CURL call: curl http://127.0.0.1:5000/Authentication/Create_user -d '{\"name\":\"Inigo\", \"last_name\":\"Lopez-Gazpio\", \"email\":\"inigo.lopezgazpio@deusto.es\"}' -X POST -H \"Content-Type: application/json\" -v");


		System.out.println(
				"We obtain the password in the response of the reply, to get this value we will need to parse the result (Marshalling)");

		Simple_pass_result result_class_password = null;
		Response response = null;
		
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path),
					new Usuario(nombre, apellido, email));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		System.out.println("Pasa el trycatch");

		String reply = response.readEntity(String.class);

		// Create a JSONObject to parse the respond inside the Simple_pass_result
		try {
			result_class_password = new Simple_pass_result(reply);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		result_class_password.print();

		contrasenya = Long.toString(result_class_password.getContentNumber());
		
		System.out.println("La contrasenya devuelta por auth es: " + contrasenya);
		
		return contrasenya;
		
		
	}

	@Override
	public boolean change_password(String email, String old_password, String new_password) 
	{
		RestClient<Usuario> client = new RestClient<>(hostname, port_auth);
		System.out.println("--------------------------------------------------------");
		System.out.println("Authentication Change Password Server test (POST)");
		System.out.println("--------------------------------------------------------");

		String path = "/Authentication/Change_password";
		System.out.println("Trying POST at " + path + " (Change_password resource)");
		System.out.println(
				"CURL call: curl http://127.0.0.1:5000/Authentication/Change_password -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"password\":\"XXX\", \"password_new\":\"XXX\"}' -X PUT -H \"Content-Type: application/json\" -v");

		try {
			client.simplePrint(client.makePutRequest(client.createInvocationBuilder(path),
					new Usuario(email, String.valueOf(new_password), old_password))); //creo que está usando el consturctor de create_user_auth que es también string,string,string
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		return false;
	}

	@Override
	public boolean delete_user(String email, String password) 
	{
		RestClient<Usuario> client = new RestClient<>(hostname, port_auth);
		System.out.println("--------------------------------------------------------");
		System.out.println("Authentication Delete_user Server test (POST)");
		System.out.println("--------------------------------------------------------");

		String path = "/Authentication/Delete_user";
		System.out.println("Trying POST at " + path + " (delete user resource)");
		System.out.println(
				"CURL call: curl http://127.0.0.1:5000/Authentication/Delete_user -d '{\"email\":\"inigo.lopezgazpio@deusto.es\", \"password\":\"XXX\" }' -X DELETE -H \"Content-Type: application/json\" -v");

		try {
			client.simplePrint(client.makePutRequest(client.createInvocationBuilder(path),
					new Usuario(email, password)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		return false;
	}

	

	@Override
	public List<Vuelo> search_flights(String aero_origen, String aero_dest, int num_pasajeros, double precio,
			Date salida)
	{
		
		RestClient<Flight_parameters> client = new RestClient<Flight_parameters>(hostname, port_airlines);

		System.out.println("------------------------------------------------------");
		System.out.println("Search flights Airlines Server test (POST) ");
		System.out.println("------------------------------------------------------");

		String path = "/Airlines/Search_Flights";
		System.out.println("Trying POST at " + path + " (Search All Flights message)");
		System.out.println(
				"CURL call: curl http://127.0.0.1:5002/Airlines/Search_Flights -d '{ }' -X POST -H \"Content-Type: application/json\" -v");

		Response response = null;
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters());
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		// JSON SIMPLE PARSER STUFF...
		List<Flight_JSON> myFlightArray;
		try {
			String json_string = response.readEntity(String.class);
			JSONParser myParser = new JSONParser();
			JSONArray flightsArray = (JSONArray) myParser.parse(json_string);

			// Lambda expression to print array
			flightsArray.stream().forEach(element -> System.out.println(element));

			// Lambda expression to map JSONObjects inside JSONArray to flight objects
			myFlightArray = (List) flightsArray.stream().map(element -> new Flight_JSON(element))
					.collect(Collectors.toList());

			System.out.println("Number of flights collected:");
			System.out.println(myFlightArray.size());

			System.out.println("Print some flight as string");
			myFlightArray.get(0).print();

			System.out.println("Print some random flight parameters");
			System.out.println(myFlightArray.get(0).getAirportArrivalCity());
			System.out.println(myFlightArray.get(0).getAirportArrivalCode());
			System.out.println(myFlightArray.get(0).getAirportDepartureCity());
			System.out.println(myFlightArray.get(0).getAirportDepartureCode());
			System.out.println(myFlightArray.get(0).getCode());
			System.out.println(myFlightArray.get(0).getDepartureDate());
			System.out.println(myFlightArray.get(0).getDepartureDate(true));
			System.out.println(myFlightArray.get(0).getDepartureDate(false));
			System.out.println(myFlightArray.get(0).getFreeSeats());
			System.out.println(myFlightArray.get(0).getTotalSeats());
			System.out.println(myFlightArray.get(0).getPrice());

		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		return null;
	}
}
