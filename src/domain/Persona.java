package domain;

import java.sql.Timestamp;

public class Persona {	
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private Timestamp fechaRegistro;
	private int telefono;
	private boolean activo;
	private String nombreUsuario;
	private String contrasenya;
	private TipoPersona tipoPersona;
	private String poblacion;
	private String provincia;
	private String tipoVia;
	private String nombreVia;
	private String numero;
	private String escalera;
	private String puerta;
	private int codigoPostal;
	
	public Persona(){
		super();
	}	

	//SETTERS y GETTERS	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}
	
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	
	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
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
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", fechaRegistro=" + fechaRegistro + ", telefono=" + telefono + ", activo=" + activo
				+ ", nombreUsuario=" + nombreUsuario + ", contrasenya=" + contrasenya + ", tipoPersona=" + tipoPersona + ", "
				+ "poblacion=" + poblacion + ", provincia=" + provincia + ", tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", "
				+ "numero=" + numero + ", escalera=" + escalera + ", puerta=" + puerta + ", codigoPostal=" + codigoPostal + "]";
	}

}