package LD;


import javax.jdo.*;

import LN.Aeropuerto;



public class GestorBD {
	
	
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	// Persistence Manager
	private PersistenceManager pm = pmf.getPersistenceManager();;

	//Transaction to group DB operations
	private Transaction tx = null;
	
	
	
	
	public <T> boolean guardarElementos( T[]a ){
		
		 boolean guardado = true;
		 
		 try 
		 {
			 
			 System.out.println("- Guardar objetos en la BD");			

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			 
			
			 for(T objeto:a) {
				 
				 pm.makePersistent(objeto);
				 
			 }
	
			 pm.setDetachAllOnCommit(true);
			
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
		 }
		 
		 return guardado;
		 
		 
	}
	
	public boolean eliminarAeropuerto(Aeropuerto a) {
		
		boolean eliminado = true;
		
		try 
		 {
			 
			 System.out.println("- Eliminar aeropuertos en la BD");			

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			 
			 // Aeropuerto aeropuertoBuscado = pm.getObjectById(Aeropuerto.class, a.getCodAeropuerto());
			 // pm.deletePersistent(aeropuertoBuscado);
			 
			 Extent<Aeropuerto> extent = pm.getExtent(Aeropuerto.class, true);

			 for (Aeropuerto aero : extent)
			 {
				 if (aero.getCodAeropuerto().equals(a.getCodAeropuerto()))
				 {
				 	System.out.println("Encontrado aeropuerto: " + aero.getCodAeropuerto());
					 pm.deletePersistent(aero);
				 }
			 }
			 
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
			
		 }
		
		return eliminado;
		
	}
	
	public boolean buscarModificarCodAeropuerto(Aeropuerto a, String nuevoCod) {
		
		boolean editado = true;
		
		try 
		 {
			 
			 System.out.println("- Editando aeropuertos en la BD");			

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			 Query q = pm.newQuery("javax.jdo.query.SQL", "UPDATE AEROPUERTO SET CODAEROPUERTO = ?1 WHERE CODAEROPUERTO = ?2");
			 q.execute(nuevoCod, a.getCodAeropuerto());

			 
//			 Extent<Aeropuerto> extent = pm.getExtent(Aeropuerto.class, true);
//
//			 for (Aeropuerto aero : extent)
//			 {
//				 if (aero.getCodAeropuerto().equals(a.getCodAeropuerto()))
//				 {
//					aero.setCodAeropuerto(nuevoCod);
//				 	System.out.println("Encontrado: " + aero.getCodAeropuerto());
//				 	// AQUI TENEÍS QUE LANZAR UNA QUERY PARA ACTUALIZAR EL VALOR DE LA BD
//				 }
//			 }
//			 
		
			 // Aeropuerto aeropuertoBuscado = pm.getObjectById(Aeropuerto.class, a.getCodAeropuerto());/
			 // Esto no useis, que este método no hace lo que parece.
			 // Si no quereis usar extents hacer una query directamente con select pasandole el id que quereis buscar
			 // Os recomiendo limitaros a los metodos que tenemos en los ejemplos de datanucleus
			 		 
			 
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
		 }
		

		return editado;
		
	}
	
	public boolean crearModificarCodAeropuerto(Aeropuerto a, String nuevoCod) {

		boolean editado = true;

		try {

			System.out.println("- Creando y modificando aeropuertos en la BD");

			//Obtain the current transaction
			tx = pm.currentTransaction();

			//Start the transaction
			tx.begin();


			Aeropuerto aero = new Aeropuerto(a.getCodAeropuerto(), a.getNombre());
			pm.makePersistent(aero);
			// esto intentaria meter un aeropuerto con codigo duplicado, en principio nos daría un error

			// si cambiamos el codigo, sin hacer un makePersistent se va a guardar actualizado
			aero.setCodAeropuerto(nuevoCod);

			//End the transaction
			tx.commit();

			System.out.println("El objeto se ha editado satisfactoriamente");
		} catch (Exception ex) {
			editado = false;

			System.err.println(" $ Error modifying object from the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				System.out.println("traza1");
				tx.rollback();
			}

		}

		return editado;
	}
	
	public <T> boolean eliminarObjeto( T a ){
		
		 boolean eliminado = true;
		 
		 try 
		 {
			 
			 System.out.println("- Eliminar objetos en la BD");			

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
		 }
		 
		 return eliminado;
		
	}
	
	public void cerrarBD() {
		
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
