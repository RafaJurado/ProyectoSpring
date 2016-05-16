package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.PersonaDao;
import domain.Persona;

@Controller
@RequestMapping("/persona") 
public class PersonaController {
	private PersonaDao personaDao; 

	@Autowired
	public void setPersonaDao(PersonaDao personaDao) { 
		this.personaDao=personaDao;
	}

	
	@RequestMapping("/list") 
	public String listPersonas(Model model) {
		model.addAttribute("personas", personaDao.getPersonas());
		return "persona/list";
	}
	
	@RequestMapping(value="/add") 
	public String addPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "persona/add";
	}	

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("persona") Persona persona,
	                                BindingResult bindingResult) { 
		PersonaValidator personaValidator = new PersonaValidator();
		personaValidator.validate(persona, bindingResult); 
		if (bindingResult.hasErrors()) 
			return "persona/add";
		personaDao.addPersona(persona);
		return "redirect:list.html"; 
	 }
	
	@RequestMapping(value="/update/{dni}", method = RequestMethod.GET) 
	public String editPersona(Model model, @PathVariable String dni) { 
		model.addAttribute("persona", personaDao.getPersona(dni));
		return "persona/update"; 
	}
	
	@RequestMapping(value="/update/{dni}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable String dni, 
                            @ModelAttribute("persona") Persona persona, 
                            BindingResult bindingResult) {
		PersonaValidator personaValidator = new PersonaValidator();
		personaValidator.validate(persona, bindingResult); 
		if (bindingResult.hasErrors()) 
			return "persona/update";
		personaDao.updatePersona(persona);
		return "redirect:../list.html"; 
	  }
	
	@RequestMapping(value="/delete/{dni}")
	 public String processDelete(@PathVariable String dni) {
		personaDao.deletePersona(dni);
		return "redirect:../list.html"; 
	 }
}
