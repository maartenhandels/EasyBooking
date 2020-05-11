package server.LD;

public class Vuelo {
	
	private Aerolinea aerolinea;
	private int codVuelo; // 4 digits
	
	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoDestino;
	
	private int asientosTotales;
	private int asientosLibres;
	
	private long salida; // Esto es porque hay que usar UNIX (fecha y hora) pero no se muy bien como va
	private long llegada; // Esto es porque hay que usar UNIX (fecha y hora) pero no se muy bien como va
	
	
	
	public Vuelo(int codVuelo, Aerolinea Aerolinea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoDestino, int asientosTotales, int asientosLibres, long salida, long llegada) 
	{
		super();
		this.codVuelo = codVuelo;
		this.aerolinea = Aerolinea;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoDestino = aeropuertoDestino;
		this.asientosTotales = asientosTotales;
		this.asientosLibres = asientosLibres;
		this.salida = salida;
		this.llegada = llegada;
	}

	public int getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(int codVuelo) {
		this.codVuelo = codVuelo;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
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

	public int getAsientosTotales() {
		return asientosTotales;
	}

	public void setAsientosTotales(int asientosTotales) {
		this.asientosTotales = asientosTotales;
	}

	public int getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(int asientosLibres) {
		this.asientosLibres = asientosLibres;
	}

	public long getSalida() {
		return salida;
	}

	public void setSalida(long salida) {
		this.salida = salida;
	}

	public long getLlegada() {
		return llegada;
	}

	public void setLlegada(long llegada) {
		this.llegada = llegada;
	}
	
	
	
	

}
