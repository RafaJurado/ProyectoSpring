package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ServicioDao;
import domain.Servicio;




@Controller
@RequestMapping("/servicio")
public class ServicioController {
    private ServicioDao servicioDao; 

    @Autowired
    public void setServicioDao(ServicioDao servicioDao) {
        this.servicioDao=servicioDao;
    }
    


    @RequestMapping("/list") 
    public String listServicio(Model model) {
        model.addAttribute("servicios", servicioDao.getServicio());
        return "servicio/list";
    }
    

    @RequestMapping(value="/add") 
    public String addServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicio/add";
    }
    

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("servicio") Servicio servicio,
                                BindingResult bindingResult) {
     if (bindingResult.hasErrors())
            return "servicio/add";
     servicioDao.addServicio(servicio);
     return "redirect:list.html";
 }
    
    @RequestMapping(value="/update/{idServicio}", method = RequestMethod.GET)
    public String editServicio(Model model, @PathVariable int idServicio) {
        model.addAttribute("servicio", servicioDao.getServicio(idServicio));
        return "servicio/update"; 
    }
    

    @RequestMapping(value="/update/{idServicio}", method = RequestMethod.POST) 
    public String processUpdateSubmit(@PathVariable int idServicio, 
                            @ModelAttribute("servicio") Servicio servicio, 
                            BindingResult bindingResult) {
         if (bindingResult.hasErrors()) 
             return "servicior/update";
         servicioDao.updateServicio(servicio);
         return "redirect:../list.html"; 
      }
    

    @RequestMapping(value="/delete/{idServicio}")
    public String processDelete(@PathVariable int idServicio) {
           	servicioDao.deleteNadador(idServicio);
           	return "redirect:../list.html"; 
 }


}
