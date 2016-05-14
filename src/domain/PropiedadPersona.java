package domain;

import java.sql.Timestamp;
import java.util.Calendar;

public class PropiedadPersona {
	//ATRIBUTOS
	private String idPersona;
	private int idPropiedad;
	private int valoracion;
	private Timestamp fechaValoracion;
	
	//CONTRUCTORES
	public PropiedadPersona(){
		super();
	}

	//GETTERS AND SETTERS
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
	
	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	public Timestamp getFechaValoracion() {
		return fechaValoracion;
	}

	public void setFechaValoracion(Timestamp fechaValoracion) {
		this.fechaValoracion = fechaValoracion;
	}
	
	@Override
	public String toString() {
		return "PropiedadPersona [idPersona=" + idPersona + ", idPropiedad=" + idPropiedad + ", "
				+ "valoracion=" + valoracion + ", fechaValoracion=" + fechaValoracion +"]";
	}

}

