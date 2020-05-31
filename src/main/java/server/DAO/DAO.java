package server.DAO;


import java.util.ArrayList;
import java.util.List;

// import javax.jdo.*;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.LD.Reserva;
import server.LD.Aerolinea;
import server.LD.Aeropuerto;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Vuelo;

public class DAO implements itfDAO {
	
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	private PersistenceManagerFactory pmf;

	// Persistence Manager
	private PersistenceManager pm;

	//Transaction to group DB operations
	private Transaction tx;
	
	public DAO(){
		this.pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
	}
	
	
	public <T> boolean guardarElemto(T a){
		
		 boolean guardado = true;
		 
		 try 
		 {
			 System.out.println("Guardar objetos en la BD...");			
			 			 
			 //Obtain the current transaction
			 tx = pm.currentTransaction();		
		
			 //Start the transaction
			 tx.begin();
			
			 pm.makePersistent(a);				 
	
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
	
	public <T> boolean guardarReserva(T a, Usuario usuario){
		
		 boolean guardado = true;
		 
		 try 
		 {		
			 System.out.println("Guardar objetos en la BD...");			

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		
		
			 //Start the transaction
			 tx.begin();
			 
			 Usuario us = (Usuario)pm.detachCopy(usuario);
			 
			 pm.makePersistent(us);
			 
			 pm.makePersistent(a);
			 
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
	
	public <T> boolean guardarVariosElemtos(ArrayList<T> a){
		
		 boolean guardado = true;
		 
		 try 
		 {	
			 System.out.println("Guardar objetos en la BD...");			

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
	
	public ArrayList<Aeropuerto> LeerAeropuertos(){
		
		ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();

		try 
		{
					 		 
			Extent<Aeropuerto> extent = pm.getExtent(Aeropuerto.class, true);
				 
			 
			for(Aeropuerto a:extent) {
				aeropuertos.add(a);
			}
			 
			 
		}
		
		catch (Exception ex) 
		{
			 System.err.println(" $ Error reading airports from the DB: " + ex.getMessage());

			 ex.printStackTrace();
		}
		
		finally 
		{
			 if (tx != null && tx.isActive()) {
				 tx.rollback();
			 }
		}
		 
		return aeropuertos;
	
	}
	
	public ArrayList<Vuelo> LeerVuelos(){
		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

		try 
		{
					 		 
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);
				 
			 
			for(Vuelo a:extent) {
				vuelos.add(a);
			}
			 
			 
		}
		
		catch (Exception ex) 
		{
			 System.err.println(" $ Error reading flights from the DB: " + ex.getMessage());

			 ex.printStackTrace();
		}
		
		finally 
		{
			 if (tx != null && tx.isActive()) {
				 tx.rollback();
			 }
		}
		 
		return vuelos;
	
	}
	
	public ArrayList<Usuario> LeerUsuarios(){
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try 
		{
					 		 
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
				 
			 
			for(Usuario a:extent) {
				usuarios.add(a);
			}
			 
			 
		}
		
		catch (Exception ex) 
		{
			 System.err.println(" $ Error reading users from the DB: " + ex.getMessage());

			 ex.printStackTrace();
		}
		
		finally 
		{
			 if (tx != null && tx.isActive()) {
				 tx.rollback();
			 }
		}
		 
		return usuarios;
	
	}
	
	public ArrayList<Pasajero> LeerPasajeros(){
		
		ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();

		try 
		{
					 		 
			Extent<Pasajero> extent = pm.getExtent(Pasajero.class, true);
				 
			 
			for(Pasajero a:extent) {
				pasajeros.add(a);
			}
			 
			 
		}
		
		catch (Exception ex) 
		{
			 System.err.println(" $ Error reading passengers from the DB: " + ex.getMessage());

			 ex.printStackTrace();
		}
		
		finally 
		{
			 if (tx != null && tx.isActive()) {
				 tx.rollback();
			 }
		}
		 
		return pasajeros;
	
	}
	
	public ArrayList<Reserva> LeerReservas(){
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		try 
		{
					 		 
			Extent<Reserva> extent = pm.getExtent(Reserva.class, true);
				 
			 
			for(Reserva a:extent) {
				reservas.add(a);
			}
			 
			 
		}
		
		catch (Exception ex) 
		{
			 System.err.println(" $ Error reading bookings from the DB: " + ex.getMessage());

			 ex.printStackTrace();
		}
		
		finally 
		{
			 if (tx != null && tx.isActive()) {
				 tx.rollback();
			 }
		}
		 
		return reservas;
	
	}
	
	public <T> boolean eliminarObjeto(T a){
		
		 boolean eliminado = true;
		 
		 try 
		 {
			 System.out.println("Eliminar objetos en la BD...");			

			 //Obtain the current transaction
			 tx = pm.currentTransaction();		

			 //Start the transaction
			 tx.begin();
			 
			 String clase = a.getClass().getSimpleName();
			 			 
			 String terminacion = ".class";
			 
			 String concatenado = clase.concat(terminacion);
			 
			 
			 Extent<T> extent = pm.getExtent((Class)a.getClass(), true);
			 
			 for (T obj : extent)
			 {
				 if(clase.equalsIgnoreCase("Aeropuerto"))
				 {
					Aeropuerto aero = (Aeropuerto)obj;
					Aeropuerto aero2 = (Aeropuerto)a;
					
					if(aero.getCodAeropuerto().equalsIgnoreCase(aero2.getCodAeropuerto())) {
						pm.deletePersistent(obj);
					}
				 }
				 else if(clase.equalsIgnoreCase("Aerolinea"))
				 {
					Aerolinea aerol = (Aerolinea)obj;
					Aerolinea aerol2 = (Aerolinea)a;
					
					if(aerol.getCodAerolinea().equalsIgnoreCase(aerol2.getCodAerolinea())) {
						pm.deletePersistent(obj);
					}
				 }
				 else if(clase.equalsIgnoreCase("Pasajero"))
				 {
					Pasajero pas = (Pasajero)obj;
					Pasajero pas2 = (Pasajero)a;
					
					if(pas.getDni().equalsIgnoreCase(pas2.getDni())) {
						pm.deletePersistent(obj);
					}
				 }
				 else if(clase.equalsIgnoreCase("Reserva"))
				 {
					Reserva res = (Reserva)obj;
					Reserva res2 = (Reserva)a;
					
					if(res.getCodReserva().equalsIgnoreCase(res2.getCodReserva())) {
						pm.deletePersistent(obj);
					}
				 }
				 else if(clase.equalsIgnoreCase("Usuario"))
				 {
					Usuario us = (Usuario)obj;
					Usuario us2 = (Usuario)a;
					
					if(us.getEmail().equalsIgnoreCase(us2.getEmail())) {
						pm.deletePersistent(obj);
					}
				 }
				 
			 }
			 			 
			 //End the transaction
			 tx.commit();			
			
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
	
	public String buscarNombreUsuario(Usuario user)
	{
		String nombre="";
		
		try
		{
			System.out.println("Consultando el nombre del usuario enviado...");			

			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();

			//Obtain the current transaction
			tx = pm.currentTransaction();		

			//Start the transaction
			tx.begin();

			Query<Usuario> query = pm.newQuery(Usuario.class);
			//query.setFilter("nombre == ");
			
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) query.execute();

			//End the transaction
			tx.commit();
			
			
			for (Usuario usuario : usuarios) 
			{
				if(usuario.getEmail()==user.getEmail())
				{
					nombre= usuario.getNombre();
					break;
				}
			}
		}

		catch (Exception ex) 
		{
			System.err.println(" $ Error retrieving user name using a 'Query': " + ex.getMessage());
		}

		finally 
		{
			if (tx != null && tx.isActive()) 
			{
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return nombre;

		
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
