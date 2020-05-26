package server.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	private float currency;
	
	
	public UsuarioDTO(String email, String nombre, String apellido, String dni)
	{
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellido=apellido;
		this.dni=dni;
		
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getDni() 
	{
		return dni;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	public float getCurrency() 
	{
		return currency;
	}

	public void setCurrency(float currency) 
	{
		this.currency = currency;
	}
	

}
