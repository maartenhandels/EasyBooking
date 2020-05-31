package server.LD;

import java.io.Serializable;

import externalServices.Print;

public class Vuelo implements Print, Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Aerolinea aerolinea;
	private String codVuelo; // 4 digits
	
	private float precio;
	
	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoDestino;
	
	private long asientosTotales;
	private long asientosLibres;
	
	private long salida; 
	private long llegada; 
	
	public Vuelo()
	{}
	
	
	public Vuelo(String codVuelo, Aerolinea Aerolinea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoDestino, long asientosTotales, long asientosLibres, long salida, long llegada, float precio) 
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
		this.precio=precio;
	}

	public float getPrecio() 
	{
		return precio;
	}


	public void setPrecio(float precio) 
	{
		this.precio = precio;
	}


	public String getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(String codVuelo) {
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

	public long getAsientosTotales() {
		return asientosTotales;
	}

	public void setAsientosTotales(long asientosTotales) {
		this.asientosTotales = asientosTotales;
	}

	public long getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(long asientosLibres) {
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


	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}
