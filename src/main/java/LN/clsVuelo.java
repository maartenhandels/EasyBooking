package main.java.LN;

public class clsVuelo {
	
	private String codVuelo;
	private String codAerolinea;
	
	private clsAeropuerto aeropuertoSalida;
	private clsAeropuerto aeropuertoDestino;
	
	// Algun atributo para los asientos libres y asi??
	
	
	public clsVuelo(String codVuelo, String codAerolinea, clsAeropuerto aeropuertoSalida, clsAeropuerto aeropuertoDestino) 
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

	public clsAeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(clsAeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public clsAeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(clsAeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	

}
