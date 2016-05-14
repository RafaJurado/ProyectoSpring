package domain;

public class Servicio {
	//ATRIBUTOS
	private int idServicio;
	private String descripcion;
	
	//CONSTRUCTORES	
	public Servicio(){
		super();
	}

	//GETTERS AND SETTERS
	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", descripcion=" + descripcion + "]";
	}	
}