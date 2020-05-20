package server.LD;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import externalServices.Print;


@PersistenceCapable
public class Usuario implements Print{
	
	@PrimaryKey
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	
	@NotPersistent
	private String contrasenya;
	private Usuario us;
	private float divisa;
	private float cant_total;
	private String concepto;
	
	@Column(name="CODAEROPUERTO")
	private Aeropuerto aeropuerto; // No se como llamarle a esto
	
	
	@Persistent(mappedBy="usuario")
	private List<Reserva> reservasUsuario; 
	
	/**
	 * Este constructor sirve para log_in y delete_user
	 * @param email
	 * @param contrasenya
	 */
	public Usuario(String email, String contrasenya)
	{
		this.email = email;
		this.contrasenya = contrasenya;
	}
	/**
	 * Este constructor sirve para create_user_auth
	 * @param email
	 * @param contrasenya
	 */
	public Usuario(String nombre, String apellido, String email)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Usuario(String email, String nombre, String apellido, String dni, Aeropuerto aeropuerto)
	{
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.aeropuerto = aeropuerto;
		this.reservasUsuario = new ArrayList <Reserva>();
	}
	
	/**
	 * Este constructor sirve para create_user_pago
	 * @param us
	 * @param divisa
	 */
	
	public Usuario(Usuario us, float divisa)
	{
		this.us = us;
		this.divisa = divisa;
	}
	/**
	 * Este constructor sirve para update_currency
	 * @param email
	 * @param divisa
	 */
	
	public Usuario(String email, float divisa)
	{
		this.email = email;
		this.divisa = divisa;
	}
	
	/**
	 * Este constructor sirve para make_Payment
	 * @param email
	 * @param cant_total
	 * @param concepto
	 */
	
	public Usuario(String email, float cant_total, String concepto)
	{
		this.email = email;
		this.cant_total = cant_total;
		this.concepto = concepto;
	}

	public Usuario()
	{
		
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


	public List<Reserva> getReservasUsuario() {
		return reservasUsuario;
	}


	public void setReservasUsuario(List<Reserva> reservasUsuario) {
		this.reservasUsuario = reservasUsuario;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}
