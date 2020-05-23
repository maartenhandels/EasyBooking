package server.Main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Fachada.Fachada;
import server.Fachada.itfFachada;

public class Main 
{
	
	private static itfFachada fachada;
	
	
	public static void main(String [] args) throws RemoteException 
	{

		String ip = args[0];
		System.out.println("La IP es: " + ip);
		
		String port = args[1];
		System.out.println("El puerto es: " + port);
		
		String serviceName = args[2];
		System.out.println("El servicename es: " + serviceName);
		
		fachada = new Fachada();
		
	
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try {
			
			Registry registry = LocateRegistry.createRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" + port + "/" + serviceName;
			
			System.out.println("El name es: " + name + "\n");
			
			registry.rebind(name, fachada);


		} 
		catch (Exception e) {
			System.err.println("- Exception running the server (main): " + e.getMessage() );
			e.printStackTrace();
		} 
	}
	
}
