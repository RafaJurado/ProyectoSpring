package domain;

public class Propiedad {
	private int idPropiedad;
	private String titulo;
	private String descripcion;
	private int capacidad;
	private int numeroHabitaciones;
	private int numeroBanyos;
	private int numeroCamas;
	private int tamanyo;
	private float precio;
	private boolean activo;
	private TipoPropiedad tipoPropiedad;
	private String poblacion;
	private String provincia;
	private String tipoVia;
	private String nombreVia;
	private String numero;
	private String escalera;
	private String puerta;
	private int codigoPostal;
	private String idPersona;
	private float valoracionMedia;
	
	
	public Propiedad(){
		super();
	}
		
	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public int getNumeroBanyos() {
		return numeroBanyos;
	}

	public void setNumeroBanyos(int numeroBanyos) {
		this.numeroBanyos = numeroBanyos;
	}

	public int getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public TipoPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}
	
	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}	

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public float getValoracionMedia() {
		return valoracionMedia;
	}

	public void setValoracionMedia(float valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}
	
	@Override
	public String toString() {
		return "Propiedad [idPropiedad=" + idPropiedad + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", capacidad=" + capacidad + ", numeroHabitaciones=" + numeroHabitaciones + ", numeroBanyos=" + numeroBanyos
				+ ", numeroCamas=" + numeroCamas + ", tamanyo=" + tamanyo + ", precio=" + precio + ", activo=" + activo
				+ ", tipoPropiedad=" + tipoPropiedad + ", poblacion=" + poblacion + ", provincia=" + provincia + ", tipoVia=" + tipoVia
				+ ", nombreVia=" + nombreVia + ", numero=" + numero + ", escalera=" + escalera + ", puerta=" + puerta
				+ ", codigoPostal=" + codigoPostal + ", idPersona=" + idPersona + ", valoracionMedia=" + valoracionMedia
				+ "]";
	}
}
