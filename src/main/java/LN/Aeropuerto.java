package LN;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto {
	
	
	@PrimaryKey
	private String codAeropuerto; // 3 Alphanumeric Characters- Ex: BIO
	
	@NotPersistent
	private String nombre; 
	
	
	
	public Aeropuerto(String nombre, String codAeropuerto) {
		super();
		this.nombre = nombre;
		this.codAeropuerto = codAeropuerto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodAeropuerto() {
		return codAeropuerto;
	}


	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}
	
	
	
	
	
	
	
	
	

}
