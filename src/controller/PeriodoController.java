package controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PeriodoDao;
import domain.Periodo;

@Controller
@RequestMapping("periodo/")
public class PeriodoController {
	private PeriodoDao periodoDao;
	
	@Autowired
	public void setPeriodoDao(PeriodoDao periodoDao){
		this.periodoDao=periodoDao;
	}
	
	//LISTAR
	@RequestMapping("/list") 
	public String listPeriodos(Model model) {
		model.addAttribute("periodos", periodoDao.getPeriodos());
		return "periodo/list";
	}
	
	//AGREGAR
	@RequestMapping(value="/add") 
	public String addPeriodo(Model model) {//si no se especifica método es GET
		model.addAttribute("periodo", new Periodo());
		return "periodo/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("periodo") Periodo periodo,
	                                BindingResult bindingResult) { 
		//agregado practica 5
		//NadadorValidator nadadorValidator = new NadadorValidator();
		//nadadorValidator.validate(nadador, bindingResult); 
		//fin agregacion
		if (bindingResult.hasErrors())
				return "periodo/add";
		 periodoDao.addPeriodo(periodo);
		 return "redirect:list.html";
	 }
	
	//MODIFICACION
	//Antes de ir a la vista, hay que proporcionarle la informacion (la lista)
	//el usuario entonces ve la informacion en la vista, hace lo que quiere y envia
	//esa informacion se envia con POST
	@RequestMapping(value="/update/{fechaInicio}", method = RequestMethod.GET)
	public String editPeriodo(Model model, @PathVariable Timestamp fechaInicio, int idPropiedad) {
		model.addAttribute("periodo", periodoDao.getPeriodo(fechaInicio, idPropiedad));
		return "periodo/update"; 
	}
	@RequestMapping(value="/update/{fechaInicio}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable Timestamp fechaInicio, int idPropiedad, 
                            @ModelAttribute("periodo") Periodo periodo, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "periodo/update";
		 periodoDao.updatePeriodo(periodo);
		 return "redirect:../list.html"; 
	}
	
	//BORRADO
	//REVISAR SI SE LE PUEDE PASAR UN OBJETO EN LUGAR DE STRING O INT
	@RequestMapping(value="/delete/{idPropiedad}")
	 public String processDelete(@PathVariable Timestamp fechaInicio, int idPropiedad) {
	           periodoDao.deletePeriodo(fechaInicio, idPropiedad);
	           return "redirect:../list.html"; 
	 }
}