package LN;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {

	@PrimaryKey
	private String codReserva; // Hay que mirar si mejor algo diferente a int
	private String codPago; // Hay que mirar si mejor algo diferente a int
	private String codVuelo; // Nose muy bien si habria que poner esto aqui
	
	private Aerolinea aerolinea;
	
	@Join
	private List<Pasajero> pasajeros = new ArrayList <Pasajero>();
	
	private boolean usuarioViaja; // Podriamos hacer algo asi para saber si el usuario es un pasajero o no
	
	

	
	
	public Reserva(String codReserva, String codPago, ArrayList<Pasajero> pasajeros, boolean usuarioViaja, String codVuelo, Aerolinea aerolinea) {
		
		super();
		this.codReserva = codReserva;
		this.codPago = codPago;
		this.pasajeros = pasajeros;
		this.usuarioViaja = usuarioViaja;
		this.codVuelo = codVuelo;
		this.aerolinea = aerolinea;
	}

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	public String getCodPago() {
		return codPago;
	}

	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
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
	
	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
	
	
}
