package server.LD;

import java.awt.List;
import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pasajero {
	
	@PrimaryKey
	private String dni;
	private String nombre;
	private String apellido;
	
	@Persistent(mappedBy="pasajeros")
	private ArrayList<Reserva> reservas;
	

	public Pasajero(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.reservas = null;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
