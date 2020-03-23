package main.java.LN;

import java.util.ArrayList;

public class clsReserva {

	private int codReserva; // Hay que mirar si mejor algo diferente a int
	private int codPago; // Hay que mirar si mejor algo diferente a int
	
	private String codVuelo; // Nose muy bien si habria que poner esto aqui
	
	private ArrayList<clsPasajero> pasajeros;
	
	private boolean usuarioViaja; // Podriamos hacer algo asi para saber si el usuario es un pasajero o no
	
	

	
	
	public clsReserva(int codReserva, int codPago, ArrayList<clsPasajero> pasajeros, boolean usuarioViaja, String codVuelo) {
		
		super();
		this.codReserva = codReserva;
		this.codPago = codPago;
		this.pasajeros = pasajeros;
		this.usuarioViaja = usuarioViaja;
		this.codVuelo = codVuelo;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public int getCodPago() {
		return codPago;
	}

	public void setCodPago(int codPago) {
		this.codPago = codPago;
	}

	public ArrayList<clsPasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<clsPasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public boolean isUsuarioViaja() {
		return usuarioViaja;
	}

	public void setUsuarioViaja(boolean usuarioViaja) {
		this.usuarioViaja = usuarioViaja;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}
	
	
	
	
}
