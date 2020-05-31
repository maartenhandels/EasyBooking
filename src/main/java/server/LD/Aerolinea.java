package server.LD;

import java.io.Serializable;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String codAerolinea; // 3 Alphanumeric Characters - Ex: IBE o KLM
	
	@NotPersistent
	private String nombre; 
		
	
	public Aerolinea(String codAerolinea, String nombre) 
	{
		super();
		this.nombre = nombre;
		this.codAerolinea = codAerolinea;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodAerolinea() {
		return codAerolinea;
	}


	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
	}
	
	
	
	
}
