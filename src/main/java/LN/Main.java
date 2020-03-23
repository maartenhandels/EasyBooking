package main.java.LN;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class Main {
	
	public static void main(String [] args) {
		
		clsAeropuerto aero1 = new clsAeropuerto("123", "Loiu");
		clsUsuario user1 = new clsUsuario("ibone", "urquiola", "7255556674G", "ibone@hotmail.com", aero1, false, true);
		
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
