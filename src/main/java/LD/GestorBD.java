package LD;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import LN.Aeropuerto;

public class GestorBD {
	
	
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	// Persistence Manager
	private PersistenceManager pm = null;

	//Transaction to group DB operations
	private Transaction tx = null;
	
	
	
	
	public <T> boolean guardarElementos( T[]a ){
		
		 boolean guardado = true;
		 
		 try 
		 {
			 
			 System.out.println("- Guardar objetos en la BD");			
			
			 //Get the Persistence Manager
			 pm = pmf.getPersistenceManager();

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			
			 for(T objeto:a) {
				 
				 pm.makePersistent(objeto);
				 
			 }
	
			
			 //End the transaction
			 tx.commit();			
			
			 System.out.println("Los objetos se han guardado satisfactoriamente");
		 }

		 catch (Exception ex) 
		 {
			 guardado = false;
			 
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
		 
		 return guardado;
		 
		 
	}
	
	public boolean eliminarAeropuerto(Aeropuerto a) {
		
		boolean eliminado = true;
		
		try 
		 {
			 
			 System.out.println("- Eliminar aeropuertos en la BD");			
			
			 //Get the Persistence Manager
			 pm = pmf.getPersistenceManager();

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
//			 Object id = pm.getObjectId(a);
//			 
//			 Object obj = pm.getObjectById(id);
			 
		
			 
			 Aeropuerto aeropuertoBuscado = pm.getObjectById(Aeropuerto.class, a.getCodAeropuerto());
			 
			 pm.deletePersistent(aeropuertoBuscado);
			 
			 
			 //End the transaction
			 tx.commit();			
			
			 System.out.println("El objeto se ha borrado satisfactoriamente");
		 }

		 catch (Exception ex) 
		 {
			 eliminado = false;
			 
			 System.err.println(" $ Error erasing object from the DB: " + ex.getMessage());
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
		

		return eliminado;
		
	}
	
	public boolean modificarCodAeropuerto(Aeropuerto a, String nuevoCod) {
		
		boolean editado = true;
		
		try 
		 {
			 
			 System.out.println("- Editando aeropuertos en la BD");			
			
			 //Get the Persistence Manager
			 pm = pmf.getPersistenceManager();

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
//			 Object id = pm.getObjectId(a);
//			 
//			 Object obj = pm.getObjectById(id);
			 
		
			 
			 Aeropuerto aeropuertoBuscado = pm.getObjectById(Aeropuerto.class, a.getCodAeropuerto());
			 
			 aeropuertoBuscado.setCodAeropuerto(nuevoCod);			 
			 
			 //End the transaction
			 tx.commit();			
			
			 System.out.println("El objeto se ha editado satisfactoriamente");
		 }

		 catch (Exception ex) 
		 {
			 editado = false;
			 
			 System.err.println(" $ Error modifying object from the DB: " + ex.getMessage());
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
		

		return editado;
		
	}
	
	public <T> boolean eliminarObjeto( T a ){
		
		 boolean eliminado = true;
		 
		 try 
		 {
			 
			 System.out.println("- Eliminar objetos en la BD");			
			
			 //Get the Persistence Manager
			 pm = pmf.getPersistenceManager();

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			 
			 //T objeto = pm.getObjectById(T.class, "ibone2@hotmail.com");
			 
			
			 
	
			
			 //End the transaction
			 tx.commit();			
			
			 System.out.println("El objeto se ha borrado satisfactoriamente");
		 }

		 catch (Exception ex) 
		 {
			 eliminado = false;
			 
			 System.err.println(" $ Error erasing object from the DB: " + ex.getMessage());
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
		 
		 return eliminado;
		 
		 
	}
	

}
