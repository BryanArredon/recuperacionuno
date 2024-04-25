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
import mx.utng.ultima.model.entity.Automovil;
import mx.utng.ultima.model.service.IAutomovilService;



@Controller
@SessionAttributes("automovil")
public class AutomovilController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IAutomovilService automovilService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/automovil/list","/automovil","/automovil/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de deseos de automoviles");
    model.addAttribute("automoviles", automovilService.list());
    return "alist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/automovil/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de deseos de automoviles");
        model.addAttribute("automovil", new Automovil());
        return "aform";
    }

    @GetMapping("/automovil/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Automovil automovil = null;
        if (id>0) {
            automovil = automovilService.getById(id);
        }else{
            return "redirect:alist";
        }

        model.addAttribute("title", "Editar deseos de automoviles");
        model.addAttribute("automovil", automovil);
        return "aform";
    }

    @PostMapping ("/automovil/form")
    public String save(@Valid Automovil automovil, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de deseos de automoviles");
            return "aform";
        }

        automovilService.save(automovil);
        return "redirect:/automovil/list";
    }

    @GetMapping("/automovil/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            automovilService.delete(id);
        }
        return "redirect:/automovil/list";
    }

}



