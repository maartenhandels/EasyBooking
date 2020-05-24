package server.DTO;

import java.io.Serializable;

import server.LD.Aerolinea;
import server.LD.Aeropuerto;

public class VueloDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aerolinea aerolinea;

	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoDestino;
	
	private long asientosLibres;
	
	private long salida; 
	private long llegada; 
	
	private float precio;
	
	
	public VueloDTO( Aerolinea Aerolinea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoDestino,  long asientosLibres, long salida, long llegada, float precio) 
	{
		super();
		this.aerolinea = Aerolinea;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoDestino = aeropuertoDestino;
		this.asientosLibres = asientosLibres;
		this.salida = salida;
		this.llegada = llegada;
		this.precio=precio;
	}


	public Aerolinea getAerolinea() 
	{
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) 
	{
		this.aerolinea = aerolinea;
	}


	public Aeropuerto getAeropuertoSalida() 
	{
		return aeropuertoSalida;
	}


	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) 
	{
		this.aeropuertoSalida = aeropuertoSalida;
	}


	public Aeropuerto getAeropuertoDestino() 
	{
		return aeropuertoDestino;
	}


	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) 
	{
		this.aeropuertoDestino = aeropuertoDestino;
	}


	public long getAsientosLibres() 
	{
		return asientosLibres;
	}


	public void setAsientosLibres(long asientosLibres) 
	{
		this.asientosLibres = asientosLibres;
	}


	public long getSalida() 
	{
		return salida;
	}


	public void setSalida(long salida) 
	{
		this.salida = salida;
	}


	public long getLlegada() 
	{
		return llegada;
	}


	public void setLlegada(long llegada) 
	{
		this.llegada = llegada;
	}


	public float getPrecio() 
	{
		return precio;
	}


	public void setPrecio(float precio) 
	{
		this.precio = precio;
	}
	

}
