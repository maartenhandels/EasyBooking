package server.LD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import externalServices.Print;


@PersistenceCapable
public class Usuario implements Print, Serializable{
    
	@PrimaryKey
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	
	@NotPersistent
	private String password;
	@NotPersistent
	private String password_new;
	
	@Column(name="CODAEROPUERTO")
	private Aeropuerto aeropuerto; // No se como llamarle a esto
	
	
	@Persistent(mappedBy="usuario")
	private List<Reserva> reservasUsuario; 
	
	/**
	 * Este constructor sirve para log_in y delete_user
	 * @param email
	 * @param password
	 */	
	 public Usuario (String email, String password) {
	        this.email = email;
	        this.password = password;
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
	
    public Usuario(String name, String last_name, String email, String password, String password_new)
    {
        this.nombre = name;
        this.apellido = last_name;
        this.email = email;
        this.password = password;
        this.password_new = password_new;
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
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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

	
	public String getPassword_new() 
	{
		return password_new;
	}
	public void setPassword_new(String password_new)
	{
		this.password_new = password_new;
	}
	@Override
	public void print() {
		System.out.println(
                "Printing Usuario" + "\n" +
                "Name: " + getNombre() + "\n" +
                "Last name: " + getApellido() + "\n" +
                "email: " + getEmail() + "\n" +
                "password: " + getPassword() + "\n"
        );
		
	}
	
}
