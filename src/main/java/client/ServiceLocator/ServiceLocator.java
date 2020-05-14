package client.ServiceLocator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.Fachada.itfFachadaAero;
import server.Fachada.itfFachadaAuth;
import server.Fachada.itfFachadaPago;

public class ServiceLocator {

	private itfFachadaAero fachadaAero;
	private itfFachadaPago fachadaPago;
	private itfFachadaAuth fachadaAuth;
	private Registry registry;
	
	
	public ServiceLocator() 
	{}
	
	public void setService()
	{
		String ip= "127.0.0.1";
		String port = "8001";
		String serviceName = "easybooking";
		
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try {
			registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" + port + "/" + serviceName;
//			this.fachadaAero = (itfFachadaAero) registry.lookup(name);
//			this.fachadaPago = (itfFachadaPago) registry.lookup(name);
			this.fachadaAuth = (itfFachadaAuth) registry.lookup(name);

		} 
		catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage() );
			e.printStackTrace();
		} 
	}
	public itfFachadaAero getServiceAero()
	{
		return fachadaAero;
	}
	public itfFachadaPago getServicePago()
	{
		return fachadaPago;
	}
	public itfFachadaAuth getServiceAuth()
	{
		System.out.println("Llega al servicelocator");
		return fachadaAuth;
	}
}
