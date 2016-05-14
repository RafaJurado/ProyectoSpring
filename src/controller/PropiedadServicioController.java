package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PropiedadServicioDao;
import domain.PropiedadServicio;


@Controller
@RequestMapping("/propiedadServicio")
public class PropiedadServicioController {
    private PropiedadServicioDao propiedadServicioDao; 

    @Autowired
    public void setPropiedadServicioDao(PropiedadServicioDao propiedadServicioDao) {
        this.propiedadServicioDao=propiedadServicioDao;
    }
    


    @RequestMapping("/list") 
    public String listPropiedadServicioDao(Model model) {
        model.addAttribute("propiedadServicios", propiedadServicioDao.getPropiedadServicio());
        return "propiedadServicio/list";
    }
    

    @RequestMapping(value="/add") 
    public String addPropiedadServicioDao(Model model) {
        model.addAttribute("propiedadServicioDao", new PropiedadServicioDao());
        return "propiedadServicioDao/add";
    }
    

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("propiedadServicio") PropiedadServicio pp,
                                BindingResult bindingResult) {
     if (bindingResult.hasErrors())
            return "propiedadServicioDao/add";
     propiedadServicioDao.addPropiedadServicio(pp);
     return "redirect:list.html";
 }
    
//    @RequestMapping(value="/update/{idServicio}/{idPropiedad}", method = RequestMethod.GET)
//    public String editNadador(Model model, @PathVariable int idServicio, @PathVariable int idPropiedad) {
//        model.addAttribute("propiedadServicio", propiedadServicioDao.getPropiedadServicio(idServicio,idPropiedad));
//        return "propiedadServicio/update"; 
//    }
//    
//
//    @RequestMapping(value="/update/{idServicio}/{idPropiedad}", method = RequestMethod.POST) 
//    public String processUpdateSubmit(@PathVariable int idServicio, @PathVariable int idPropiedad, 
//                            @ModelAttribute("propiedadServicio") PropiedadServicio pp, 
//                            BindingResult bindingResult) {
//         if (bindingResult.hasErrors()) 
//             return "propiedadServicio/update";
//         propiedadServicioDao.updatePropiedadServicio(pp);
//         return "redirect:../list.html"; 
//      }
    

    @RequestMapping(value="/delete/{idServicio}/{idPropiedad}")
    public String processDelete(@PathVariable int idServicio, @PathVariable int idPropiedad) {
    		propiedadServicioDao.deletePropiedadServicio(idServicio,idPropiedad);
           	return "redirect:../../list.html"; 
 }


}



