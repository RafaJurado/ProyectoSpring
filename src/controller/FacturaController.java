package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.FacturaDao;
import domain.Factura;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	private FacturaDao facturaDao;
	
	@Autowired
	public void setFacturaDao(FacturaDao facturadao){
		this.facturaDao=facturadao;
	}
	//LISTAR
	@RequestMapping("/list") 
	public String listFacturas(Model model) {
		
		model.addAttribute("facturas", facturaDao.getFacturas());
		return "factura/list";
	}
	
	//AGREGAR
	@RequestMapping(value="/add") 
	public String addFactura(Model model) {//si no se especifica método es GET
		model.addAttribute("factura", new Factura());
		return "nadador/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("factura") Factura factura,
	                                BindingResult bindingResult) { 
		//agregado practica 5
		//NadadorValidator nadadorValidator = new NadadorValidator();
		//nadadorValidator.validate(nadador, bindingResult); 
		//fin agregacion
		if (bindingResult.hasErrors())
				return "factura/add";
		 facturaDao.addFactura(factura);
		 return "redirect:list.html";
	 }
	//MODIFICACION
	@RequestMapping(value="/update/{idFactura}", method = RequestMethod.GET)
	public String editFactura(Model model, @PathVariable int idFactura) {
		model.addAttribute("factura", facturaDao.getFactura(idFactura));
		return "factura/update"; 
	}
	@RequestMapping(value="/update/{idFactura}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int idFactura, 
                            @ModelAttribute("factura") Factura factura, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "factura/update";
		 facturaDao.updateFactura(factura);
		 return "redirect:../list.html"; 
	}
	
	//BORRADO
	@RequestMapping(value="/delete/{idFactura}")
	 public String processDelete(@PathVariable int idFactura) {
	           facturaDao.deleteFactura(idFactura);
	           return "redirect:../list.html"; 
	 }
	
}
