package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.ReservaDao;
import domain.Reserva;

@Controller
@RequestMapping("/reserva") 
public class ReservaController {
	private ReservaDao reservaDao; 

	@Autowired
	public void setReservaDao(ReservaDao reservaDao) { 
		this.reservaDao=reservaDao;
	}
	
	@RequestMapping("/list") 
	public String listReservas(Model model) {
		model.addAttribute("reservas", reservaDao.getReservas());
		return "reserva/list";
	}
	@RequestMapping(value="/add") 
	public String addReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "reserva/add";
	}	

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva,
	                                BindingResult bindingResult) {  
		 if (bindingResult.hasErrors()) 
				return "reserva/add";
		 reservaDao.addReserva(reserva);
		 return "redirect:list.html"; 
	 }
	
	@RequestMapping(value="/update/{idReserva}", method = RequestMethod.GET) 
	public String editReserva(Model model, @PathVariable int idReserva) { 
		model.addAttribute("reserva", reservaDao.getReserva(idReserva));
		return "reserva/update"; 
	}
	
	@RequestMapping(value="/update/{idReserva}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int idReserva, 
                            @ModelAttribute("reserva") Reserva reserva, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "reserva/update";
		 reservaDao.updateReserva(reserva);
		 return "redirect:../list.html"; 
	  }
	
	@RequestMapping(value="/delete/{idReserva}")
	 public String processDelete(@PathVariable int idReserva) {
	           reservaDao.deleteReserva(idReserva);;
	           return "redirect:../list.html"; 
	 }
}
