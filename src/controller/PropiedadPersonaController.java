package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PropiedadPersonaDao;
import domain.PropiedadPersona;



@Controller
@RequestMapping("/propiedadPersona")
public class PropiedadPersonaController {
    private PropiedadPersonaDao propiedadPersonaDao; 

    @Autowired
    public void setNadadorDao(PropiedadPersonaDao propiedadPersonaDao) {
        this.propiedadPersonaDao=propiedadPersonaDao;
    }
    


    @RequestMapping("/list") 
    public String listPropiedadPersona(Model model) {
        model.addAttribute("propiedadPersonas", propiedadPersonaDao.getPropiedadPersona());
        return "propiedadPersona/list";
    }
    

    @RequestMapping(value="/add") 
    public String addPropiedadPersona(Model model) {
        model.addAttribute("propiedadPersona", new PropiedadPersona());
        return "propiedadPersona/add";
    }
    

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("propiedadPersona") PropiedadPersona pp,
                                BindingResult bindingResult) {
     if (bindingResult.hasErrors())
            return "propiedadPersona/add";
     propiedadPersonaDao.addPropiedadPersona(pp);
     return "redirect:list.html";
 }
    
    @RequestMapping(value="/update/{idPersona}/{idPropiedad}", method = RequestMethod.GET)
    public String editPropiedadPersona(Model model, @PathVariable int idPersona, @PathVariable int idPropiedad) {
        model.addAttribute("propiedadPersona", propiedadPersonaDao.getPropiedadPersona(idPersona, idPropiedad));
        return "propiedadPersona/update"; 
    }
    

    @RequestMapping(value="/update/{idPersona}/{idPropiedad}", method = RequestMethod.POST) 
    public String processUpdateSubmit(@PathVariable int idPersona, @PathVariable int idPropiedad, 
                            @ModelAttribute("propiedadPersona") PropiedadPersona pp, 
                            BindingResult bindingResult) {
         if (bindingResult.hasErrors()) 
             return "propiedadPersona/update";
         propiedadPersonaDao.updatePropiedadPersona(pp);
         return "redirect:../../list.html"; 
      }
    

    @RequestMapping(value="/delete/{idPersona}/{idPropiedad}")
    public String processDelete(@PathVariable int idPersona, @PathVariable int idPropiedad) {
           	propiedadPersonaDao.deletePropiedadPersona(idPersona,idPropiedad);
           	return "redirect:../../list.html"; 
 }


}


