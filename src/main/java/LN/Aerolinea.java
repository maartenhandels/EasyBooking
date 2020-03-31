package LN;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable ="true")
public class Aerolinea {

	@PrimaryKey
	private String codAerolinea; // 3 Alphanumeric Characters - Ex: IBE o KLM
	
	@NotPersistent
	private String nombre; 
	
	// Hay algo de unas comisiones que nose si deberian ir aqui
	
	
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
