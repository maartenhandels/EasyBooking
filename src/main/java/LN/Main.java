package LN;

import java.util.ArrayList;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class Main 
{
	
	public static void main(String [] args) 
	{
		
		Aeropuerto aero1 = new Aeropuerto("123", "Loiu");
		Aeropuerto aero2 = new Aeropuerto("234", "Biarritz");
		
		Aerolinea aerol1 = new Aerolinea("Iberia", "IB");
				
		Vuelo vuelo1 = new Vuelo(1234, aerol1, aero1, aero2, 100, 70, 1233131231, 1231231312);
		
		Usuario user1 = new Usuario("ibone@hotmail.com", aero1, false, true);
		Usuario user2 = new Usuario("maite@gmail.com", aero2, true, true);
		
		ArrayList<Pasajero> pasajeros = new ArrayList <Pasajero>();
		
		Pasajero pas1 = new Pasajero("Maarten", "Handels", "72345634K");
		Pasajero pas2 = new Pasajero("Laura", "Llorente", "73035427Y");
		Pasajero pas3 = new Pasajero("Gabriela", "Garaizabal", "73542711T");
		
		pasajeros.add(pas1);
		pasajeros.add(pas2);
		pasajeros.add(pas3);
		
		Reserva res1 = new Reserva("Res01", "Pag01", pasajeros, true, vuelo1);
		
		user1.getReservasUsuario().add(res1);
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		// Persistence Manager
		PersistenceManager pm = null;

		//Transaction to group DB operations
		Transaction tx = null;		
		
		try 
		{
			System.out.println("- Guardar objetos en la BD");			
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();

			//Obtain the current transaction
			tx = pm.currentTransaction();		

			//Start the transaction
			tx.begin();
			
			pm.makePersistent(user1);
			pm.makePersistent(user2);
			pm.makePersistent(pas1);
			pm.makePersistent(pas2);
			pm.makePersistent(pas3);
			pm.makePersistent(aero1);
			pm.makePersistent(res1);
	
			
			//End the transaction
			tx.commit();			
			
			System.out.println("Los objetos se han guardado satisfactoriamente");
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
		
		
		try
		{
			System.out.println("- Limpiar la BD");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();
			//Start the transaction
			tx.begin();
			
			//Delete users from DB
			
			Query<Usuario> query1 = pm.newQuery(Usuario.class);
			System.out.println(" Usuarios eliminados ");
			
			Query<Aeropuerto> query2 = pm.newQuery(Aeropuerto.class);
			System.out.println(" Aeropuertos eliminados ");
			
			Query<Pasajero> query3 = pm.newQuery(Pasajero.class);
			System.out.println(" Pasajeros eliminados ");
			
			Query<Aerolinea> query4 = pm.newQuery(Aerolinea.class);
			System.out.println(" Aerolineas eliminadas ");
			
			Query<Reserva> query5 = pm.newQuery(Reserva.class);
			System.out.println(" Reservas eliminadas ");
			
			//End the transaction
			tx.commit();
		}

		catch (Exception ex)
		{
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		}

		finally
		{
			if (tx != null && tx.isActive()) 
			{
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) 
			{
				pm.close();
			}
		}

		
	}

}
