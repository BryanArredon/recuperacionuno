package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.Television;
import mx.utng.ultima.model.service.ITelevisionService;



@Controller
@SessionAttributes("television")
public class TelevisionController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private ITelevisionService televisionService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/television/list","/television","/television/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de consumo de television");
    model.addAttribute("televisiones", televisionService.list());
    return "tlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/television/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de consumo de television");
        model.addAttribute("television", new Television());
        return "tform";
    }

    @GetMapping("/television/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Television television = null;
        if (id>0) {
            television = televisionService.getById(id);
        }else{
            return "redirect:tlist";
        }

        model.addAttribute("title", "Editar lista de consumo de television");
        model.addAttribute("television", television);
        return "tform";
    }

    @PostMapping ("/television/form")
    public String save(@Valid Television television, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de consumo de television");
            return "tform";
        }

        televisionService.save(television);
        return "redirect:/television/list";
    }

    @GetMapping("/television/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            televisionService.delete(id);
        }
        return "redirect:/television/list";
    }

}



