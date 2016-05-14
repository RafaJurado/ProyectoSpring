package domain;

import java.sql.Timestamp;

public class Reserva {
	//ATRIBUTOS
	private int idReserva;
	private Timestamp fechaSolicitud;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private int numeroPersonas;
	private float precioTotal;
	private Status estado;
	private String idPersona;
	private int idPropiedad;
	
	//CONSTRUCTORES
	public Reserva(){
		super();
	}

	//GETTERS AND SETTERS
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Timestamp getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	
	public Status getStatus() {
		return estado;
	}

	public void setStatus(Status estado) {
		this.estado = estado;
	}
	
	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}	

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", fechaSolicitud=" + fechaSolicitud + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", numeroPersonas=" + numeroPersonas + ", precioTotal="
				+ precioTotal + ", estado=" + estado + ", idPersona=" + idPersona + ", idPropiedad=" + idPropiedad + "]";
	}
}
