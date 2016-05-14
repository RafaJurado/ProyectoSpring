package domain;

import java.sql.Timestamp;

public class Imagen {
	//ATRIBUTOS
	private String nombreImagen;
	private int idPropiedad ;
	private Timestamp fechaSubida;
	
	//CONSTRUCTORES
	public Imagen(){
		super();
	}	

	//GETTERS AND SETTERS
	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public Timestamp getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Timestamp fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	@Override
	public String toString() {
		return "Imagen [nombreImagen=" + nombreImagen + ", idPropiedad=" + idPropiedad + ", fechaSubida=" + fechaSubida + "]";
	}
}
