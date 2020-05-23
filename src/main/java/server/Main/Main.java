package server.Main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.Fachada.FachadaAero;
import server.Fachada.FachadaAuth;
import server.Fachada.FachadaPago;
import server.Fachada.itfFachadaAero;
import server.Fachada.itfFachadaAuth;
import server.Fachada.itfFachadaPago;

public class Main 
{
	// private static Registry registry;
	private static itfFachadaAuth fachadaAuth;
	private static itfFachadaPago fachadaPago;
	private static itfFachadaAero fachadaAero;
	
	public static void main(String [] args) throws RemoteException 
	{

		String ip = args[0];
		System.out.println("La IP es: " + ip);
		
		String port = args[1];
		System.out.println("El puerto es: " + port);
		
		String serviceName = args[2];
		System.out.println("El servicename es: " + serviceName);
		
		
		
		fachadaAuth = new FachadaAuth();
//		fachadaPago = new FachadaPago();
//		fachadaAero = new FachadaAero();
		
		System.out.println("Llega aqui 01: \n");
	
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try {
			
			System.out.println("Llega aqui 02: " + port + "\n");
			
			Registry registry = LocateRegistry.createRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" + port + "/" + serviceName;
			
			System.out.println("El name es: " + name + "\n");
			
			
			System.out.println("Llega aqui 04: \n");
			registry.rebind(name, fachadaAuth);
			
//			System.out.println("Llega aqui 05: \n");
//			registry.rebind(name, fachadaPago);
//			
//			System.out.println("Llega aqui 3: \n");
//			registry.rebind(name, fachadaAero);

		} 
		catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage() );
			e.printStackTrace();
		} 
	}
	
}
