package server.LD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva implements Serializable{

	@PrimaryKey
	private String codReserva; // Habría que generar de alguna manera un numero random
	private String codPago; // Habría que generar de alguna manera un numero random
	
	@Column(name="USUARIO_EMAIL")
	private Usuario usuario;
	
	@Column(name="AEROLINEA_CODAEROLINEA")
	private Aerolinea aerolinea;
	
	@NotPersistent
	private Vuelo vuelo; 
	
	@Persistent(table="RESERVA_PASAJEROS")
    @Join(column="RESERVA_CODRESERVA")
    @Element(column="PASAJERO_DNI")
	private List<Pasajero> pasajeros = new ArrayList <Pasajero>();
	
	
	@NotPersistent
	private int numeroPasajeros;
	
	@NotPersistent
	private boolean usuarioViaja;
	
	
	
	
	public Reserva(Usuario usuario, String codReserva, String codPago, ArrayList<Pasajero> pasajeros, boolean usuarioViaja, Vuelo vuelo) {
		
		super();
		this.usuario = usuario;
		this.codReserva = codReserva;
		this.codPago = codPago;
		this.pasajeros = pasajeros;
		this.usuarioViaja = usuarioViaja;
		this.vuelo = vuelo;
		this.aerolinea = vuelo.getAerolinea();
		
		if(usuarioViaja == true){
			this.numeroPasajeros = pasajeros.size() + 1;
		}else {
			this.numeroPasajeros = pasajeros.size();
		}
		
	}
	
	public Reserva(Usuario usuario, String codReserva, String codPago, Vuelo vuelo) {
		
		super();
		this.usuario = usuario;
		this.codReserva = codReserva;
		this.codPago = codPago;
		this.vuelo = vuelo;
		this.aerolinea = vuelo.getAerolinea();
		
	}
	
	public Reserva(String codReserva, String codPago, Vuelo vuelo) {
		
		super();
		this.codReserva = codReserva;
		this.codPago = codPago;
		this.vuelo = vuelo;
		this.aerolinea = vuelo.getAerolinea();
		
	}

	public Reserva(String cod_reserva, String cod_pago) 
	{
		this.codPago = cod_pago;
		this.codReserva = cod_reserva;
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
	
	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}

	public void setNumeroPasajeros(int numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
}
