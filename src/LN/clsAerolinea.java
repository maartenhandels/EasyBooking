package LN;

public class clsAerolinea {

	private String nombre;
	private String codAerolinea;
	
	
	public clsAerolinea(String nombre, String codAerolinea) 
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
