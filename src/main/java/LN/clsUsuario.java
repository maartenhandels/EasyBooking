package main.java.LN;

import java.util.ArrayList;

public class clsUsuario {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	
	private clsAeropuerto aeropuerto; // No se como llamarle a esto
	
	private String metodoAutorizacion; // Habria que mirar si no es mejor con algo distinto a String
	private String metodoPago; // Habria que mirar si no es mejor con algo distinto a String
	
	private ArrayList<clsReserva> reservasUsuario;
	
	
	public clsUsuario(String nombre, String apellido, String dni, String email, clsAeropuerto aeropuerto, String metodoAutorizacion, String metodoPago)
	{
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.aeropuerto = aeropuerto;
		this.metodoAutorizacion = metodoAutorizacion;
		this.metodoPago = metodoPago;
		this.reservasUsuario = new ArrayList<clsReserva>();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public clsAeropuerto getAeropuerto() {
		return aeropuerto;
	}


	public void setAeropuerto(clsAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}


	public String getmetodoAutorizacion() {
		return metodoAutorizacion;
	}


	public void setMetodoAutorizacion(String metodoAutorizacion) {
		this.metodoAutorizacion = metodoAutorizacion;
	}


	public String getmetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}


	public ArrayList<clsReserva> getReservasUsuario() {
		return reservasUsuario;
	}


	public void setReservasUsuario(ArrayList<clsReserva> reservasUsuario) {
		this.reservasUsuario = reservasUsuario;
	}
	
	
	
	
}
