package LN;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {

	@PrimaryKey
	private String codAerolinea;
	private String nombre;
	
	
	public Aerolinea(String nombre, String codAerolinea) 
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
