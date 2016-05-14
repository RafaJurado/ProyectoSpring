package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ImagenDao;
import domain.Imagen;

@Controller
@RequestMapping("/imagen")
public class ImagenController {
	private ImagenDao imagenDao;
	
	@Autowired
	public void setImagenDao(ImagenDao imagenDao){
		this.imagenDao=imagenDao;
	}
	
	//LISTAR
	@RequestMapping("/list") 
	public String listImagenes(Model model) {
		model.addAttribute("imagenes", imagenDao.getImagenes());
		return "imagen/list";
	}
	
	//AGREGAR
	@RequestMapping(value="/add") 
	public String addNadador(Model model) {//si no se especifica método es GET
		model.addAttribute("imagen", new Imagen());
		return "imagen/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("imagen") Imagen imagen,
	                                BindingResult bindingResult) { 
		//agregado practica 5
		//NadadorValidator nadadorValidator = new NadadorValidator();
		//nadadorValidator.validate(nadador, bindingResult); 
		//fin agregacion
		if (bindingResult.hasErrors())
				return "imagen/add";
		 imagenDao.addImagen(imagen);
		 return "redirect:list.html";
	 }
	//MODIFICACION
	//Antes de ir a la vista, hay que proporcionarle la informacion (la lista)
	//el usuario entonces ve la informacion en la vista, hace lo que quiere y envia
	//esa informacion se envia con POST
	@RequestMapping(value="/update/{idPropiedad}/{nombreImagen}", method = RequestMethod.GET)
	public String editImagen(Model model, @PathVariable int idPropiedad, 
			@PathVariable String nombreImagen) {
		model.addAttribute("imagen", imagenDao.getImagen(nombreImagen, idPropiedad));
		return "imagen/update"; 
	}
	@RequestMapping(value="/update/{idPropiedad}/{nombreImagen}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int idPropiedad, 
							@PathVariable String nombreImagen, 
                            @ModelAttribute("imagen") Imagen imagen, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "imagen/update";
		 imagenDao.updateImagen(imagen);
		 return "redirect:../../list.html"; 
	}
	
	//BORRADO
	@RequestMapping(value="/delete/{idPropiedad}/{nombreImagen}")
	 public String processDelete(@PathVariable int idPropiedad, @PathVariable String nombreImagen) {
	           imagenDao.deleteImagen(nombreImagen, idPropiedad);
	           return "redirect:../../list.html"; 
	 }
}
