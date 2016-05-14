package domain;

import java.sql.Timestamp;

public class Periodo {

	//ATRIBUTOS
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private int idPropiedad;
	
	//CONTRUCTORES
	public Periodo(){
		super();
	}

	//GETTERS AND SETTERS
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

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	@Override
	public String toString() {
		return "Periodo [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idPropiedad=" + idPropiedad + "]";
	}
}
