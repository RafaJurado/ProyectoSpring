package domain;

public class ObjPropPersona {
	private Propiedad propiedad;
	private Persona persona;
	
	public ObjPropPersona(){
		this.propiedad = new Propiedad();
		this.persona = new Persona();
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
