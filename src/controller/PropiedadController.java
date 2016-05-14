package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PropiedadDao;
import domain.Propiedad;

@Controller
@RequestMapping("/propiedad")
public class PropiedadController {
	private PropiedadDao proDao;
	
	@Autowired
	public void setPropiedadDao(PropiedadDao propiedadDao){
		this.proDao=propiedadDao;
	}
	
	//LISTAR
	@RequestMapping("/list") 
	public String listaPropiedad(Model model) {
		
		model.addAttribute("propiedades", proDao.getPropiedades());
		return "propiedad/list";
	}
	
	//AGREGAR
	@RequestMapping(value="/add") 
	public String addPropiedad(Model model) {//si no se especifica método es GET
		model.addAttribute("propiedad", new Propiedad());
		return "propiedad/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("propiedad") Propiedad p,
	                                BindingResult bindingResult) { 
		//agregado practica 5
		//NadadorValidator nadadorValidator = new NadadorValidator();
		//nadadorValidator.validate(nadador, bindingResult); 
		//fin agregacion
		if (bindingResult.hasErrors())
				return "propiedad/add";
		 proDao.addPropiedad(p);
		 return "redirect:list.html";
	}
	
	//MODIFICACION
	@RequestMapping(value="/update/{idPropiedad}", method = RequestMethod.GET)
	public String editPropiedad(Model model, @PathVariable int idPropiedad) {
		model.addAttribute("propiedad", proDao.getPropiedad(idPropiedad));
		return "propiedad/update"; 
	}
	@RequestMapping(value="/update/{idPropiedad}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int idPropiedad, 
                            @ModelAttribute("propiedad") Propiedad p, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "propiedad/update";
		 proDao.updatePropiedad(p);
		 return "redirect:../list.html"; 
	}
	
	//BORRADO
	//REVISAR en PropiedadDao el metodo deletePropiedad
	@RequestMapping(value="/delete/{idPropiedad}")
	 public String processDelete(@PathVariable int idPropiedad) {
	           proDao.deletePropiedad(idPropiedad);
	           return "redirect:../list.html"; 
	 }
	
}
