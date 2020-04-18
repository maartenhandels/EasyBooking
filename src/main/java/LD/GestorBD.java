package LD;


import javax.jdo.*;

import LN.Aerolinea;
import LN.Aeropuerto;
import LN.Pasajero;
import LN.Reserva;
import LN.Usuario;
import LN.Vuelo;



public class GestorBD {
	
	
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	// Persistence Manager
	private PersistenceManager pm = pmf.getPersistenceManager();

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
			 
			 String clase = a.getClass().getSimpleName();
			 
			 System.out.println("La clase del objeto a borrar es: " + clase);
			 
			 String terminacion = ".class";
			 
			 String concatenado = clase.concat(terminacion);
			 
			 
			 
			 
			 Extent<T> extent = pm.getExtent((Class)a.getClass(), true);
			 
 			 for (T obj : extent)
 			 {
 				 if(clase.equalsIgnoreCase("Aeropuerto"))
 				 {
 					System.out.println("Ha entrado 1");
 					Aeropuerto aero = (Aeropuerto)obj;
 					Aeropuerto aero2 = (Aeropuerto)a;
 					
 					if(aero.getCodAeropuerto().equalsIgnoreCase(aero2.getCodAeropuerto())) {
 						pm.deletePersistent(obj);
 						System.out.println("Ha entrado 2");
 					}
 				 }
 				 else if(clase.equalsIgnoreCase("Aerolinea"))
				 {
					System.out.println("Ha entrado 3");
					Aerolinea aerol = (Aerolinea)obj;
					Aerolinea aerol2 = (Aerolinea)a;
					
					if(aerol.getCodAerolinea().equalsIgnoreCase(aerol2.getCodAerolinea())) {
						pm.deletePersistent(obj);
						System.out.println("Ha entrado 4");
					}
				 }
 				 else if(clase.equalsIgnoreCase("Pasajero"))
				 {
					System.out.println("Ha entrado 5");
					Pasajero pas = (Pasajero)obj;
					Pasajero pas2 = (Pasajero)a;
					
					if(pas.getDni().equalsIgnoreCase(pas2.getDni())) {
						pm.deletePersistent(obj);
						System.out.println("Ha entrado 6");
					}
				 }
 				 else if(clase.equalsIgnoreCase("Reserva"))
				 {
					System.out.println("Ha entrado 7");
					Reserva res = (Reserva)obj;
					Reserva res2 = (Reserva)a;
					
					if(res.getCodReserva().equalsIgnoreCase(res2.getCodReserva())) {
						pm.deletePersistent(obj);
						System.out.println("Ha entrado 8");
					}
				 }
 				 else if(clase.equalsIgnoreCase("Usuario"))
				 {
					System.out.println("Ha entrado 9");
					Usuario us = (Usuario)obj;
					Usuario us2 = (Usuario)a;
					
					if(us.getEmail().equalsIgnoreCase(us2.getEmail())) {
						pm.deletePersistent(obj);
						System.out.println("Ha entrado 10");
					}
				 }
 				 
 			 }
			 
			 
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
