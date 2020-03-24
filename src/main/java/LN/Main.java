package LN;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class Main {
	
	public static void main(String [] args) {
		
		Aeropuerto aero1 = new Aeropuerto("123", "Loiu");
		Aeropuerto aero2 = new Aeropuerto("234", "Biarritz");
		
		Aerolinea aerol1 = new Aerolinea("Iberia", "IB");
		
		Usuario user1 = new Usuario("ibone", "urquiola", "7255556674G", "ibone@hotmail.com", aero1, false, true);
		
		ArrayList<Pasajero> pasajeros = new ArrayList <Pasajero>();
		
		Pasajero pas1 = new Pasajero("Maarten", "Handels", "72345634K");
		Pasajero pas2 = new Pasajero("Laura", "Llorente", "73035427Y");
		Pasajero pas3 = new Pasajero("Gabriela", "Garaizabal", "73542711T");
		
		pasajeros.add(pas1);
		pasajeros.add(pas2);
		pasajeros.add(pas3);
		
		Reserva res1 = new Reserva("Res01", "Pag01", pasajeros, true, "IB0987",aerol1 );
		
		user1.getReservasUsuario().add(res1);
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		// Persistence Manager
		PersistenceManager pm = null;

		//Transaction to group DB operations
		Transaction tx = null;		
		
		try 
		{
			System.out.println("- Store objects in the DB");			
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();

			//Obtain the current transaction
			tx = pm.currentTransaction();		

			//Start the transaction
			tx.begin();
			
			pm.makePersistent(user1);
			pm.makePersistent(pas1);
			pm.makePersistent(pas2);
			pm.makePersistent(pas3);
			pm.makePersistent(aero1);
			pm.makePersistent(res1);
	
			
			//End the transaction
			tx.commit();			
			
			System.out.println("UEEEEEEEE");
		}

		catch (Exception ex) 
		{
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		}

		finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) 
			{
				pm.close();
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
		
	}

}
