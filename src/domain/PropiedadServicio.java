package domain;

public class PropiedadServicio {
	//ATRIBUTOS
	private int idServicio;
	private int idPropiedad;
	
	//CONSTRUCTORES
	public PropiedadServicio(){
		super();
	}

	//GETTERS AND SETTERS
	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	@Override
	public String toString() {
		return "PropiedadServicio [idServicio=" + idServicio + ", idPropiedad=" + idPropiedad + "]";
	}
	
}