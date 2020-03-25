package LN;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	
	private Aeropuerto aeropuerto; // No se como llamarle a esto
	
	private boolean metodoAutorizacion; // Habria que mirar si no es mejor con algo distinto a String
	private boolean metodoPago;
	
	
	@Join
	private List<Reserva> reservasUsuario = new ArrayList <Reserva>();
	
	
	public Usuario(String nombre, String apellido, String dni, String email, Aeropuerto aeropuerto, boolean metodoAutorizacion, boolean metodoPago)
	{
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.aeropuerto = aeropuerto;
		this.metodoAutorizacion = metodoAutorizacion;
		this.metodoPago = metodoPago;
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


	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}


	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}


	public boolean getmetodoAutorizacion() {
		return metodoAutorizacion;
	}


	public void setMetodoAutorizacion(boolean metodoAutorizacion) {
		this.metodoAutorizacion = metodoAutorizacion;
	}


	public boolean getmetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(boolean metodoPago) {
		this.metodoPago = metodoPago;
	}


	public List<Reserva> getReservasUsuario() {
		return reservasUsuario;
	}


	public void setReservasUsuario(List<Reserva> reservasUsuario) {
		this.reservasUsuario = reservasUsuario;
	}
	
	
	
	
}