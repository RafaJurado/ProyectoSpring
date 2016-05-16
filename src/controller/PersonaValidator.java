package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import domain.Persona;

public class PersonaValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return Persona.class.equals(cls);
  }
 
  @Override
  public void validate(Object obj, Errors errors) {
	 Persona persona = (Persona)obj;
	 
	 if (persona.getDni().trim().equals(""))
		 errors.rejectValue("dni", "obligatorio", "valor requerido");
	 if (persona.getNombre().trim().equals(""))
		 errors.rejectValue("nombre", "obligatorio", "valor requerido");
	 if (persona.getApellidos().trim().equals(""))
		 errors.rejectValue("apellidos", "obligatorio", "valor requerido");
	 if (persona.getEmail().trim().equals(""))
		 errors.rejectValue("email", "obligatorio", "valor requerido");
	 if (persona.getNombreUsuario().equals(""))
		 errors.rejectValue("nombreUsuario", "obligatorio", "valor requerido");
	 if (persona.getContrasenya().equals(""))
		 errors.rejectValue("contrasenya", "obligatorio", "valor requerido");
	 if (persona.getPoblacion().equals(""))
		 errors.rejectValue("poblacion", "obligatorio", "valor requerido");
	 if (persona.getProvincia().equals(""))
		 errors.rejectValue("provincia", "obligatorio", "valor requerido");
	 if (persona.getTipoVia().equals(""))
		 errors.rejectValue("tipoVia", "obligatorio", "valor requerido");
	 if (persona.getNumero().equals(""))
		 errors.rejectValue("numero", "obligatorio", "valor requerido");
//	 if (persona.getCodigoPostal() < '0' || persona.getCodigoPostal() > '9' )
//		 errors.rejectValue("codigoPostal", "obligatorio", "valor numerico requerido");

   
   }
}
