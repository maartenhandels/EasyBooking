package LN;

public class Vuelo {
	
	private String codVuelo;
	private String codAerolinea;
	
	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoDestino;
	
	// Algun atributo para los asientos libres y asi??
	
	
	public Vuelo(String codVuelo, String codAerolinea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoDestino) 
	{
		super();
		this.codVuelo = codVuelo;
		this.codAerolinea = codAerolinea;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}

	public String getCodAerolinea() {
		return codAerolinea;
	}

	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
	}

	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	

}
