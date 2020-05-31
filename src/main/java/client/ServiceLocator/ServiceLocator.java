package client.ServiceLocator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Fachada.itfFachada;

public class ServiceLocator {

	private itfFachada fachada;
	private Registry registry;
	
	
	public ServiceLocator() 
	{}
	
	public void setService(String [] args)
	{
		
		
		String ip = args[0];
		System.out.println("La IP del SetService es: " + ip);
		String port = args[1];
		System.out.println("El port del SetService es: " + port);
		String serviceName = args[2];
		System.out.println("El serviceName del SetService es: " + serviceName);
		
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try {
			
			registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));

			String name = "//" + ip + ":" + port + "/" + serviceName;
			
			this.fachada = (itfFachada) registry.lookup(name);

		} 
		catch (Exception e) {
			System.err.println("- Exception running the client (in SetServiceLocator): \n" + e.getMessage() );
			e.printStackTrace();
		} 
	}
	public itfFachada getService()
	{
		return fachada;
	}
}
