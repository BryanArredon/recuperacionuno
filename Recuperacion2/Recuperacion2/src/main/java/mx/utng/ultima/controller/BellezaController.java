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
import mx.utng.ultima.model.entity.Belleza;
import mx.utng.ultima.model.service.IBellezaService;



@Controller
@SessionAttributes("belleza")
public class BellezaController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IBellezaService bellezaService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/belleza/list","/belleza","/belleza/"})
    public String list(Model model){
        model.addAttribute("title", "Gastos de belleza");
    model.addAttribute("bellezas", bellezaService.list());
    return "blist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/belleza/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de gastos en belleza");
        model.addAttribute("belleza", new Belleza());
        return "bform";
    }

    @GetMapping("/belleza/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Belleza belleza = null;
        if (id>0) {
            belleza = bellezaService.getById(id);
        }else{
            return "redirect:blist";
        }

        model.addAttribute("title", "Editar gastos en cuidado de belleza");
        model.addAttribute("belleza", belleza);
        return "bform";
    }

    @PostMapping ("/belleza/form")
    public String save(@Valid Belleza belleza, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos en belleza");
            return "bform";
        }

        bellezaService.save(belleza);
        return "redirect:/belleza/list";
    }

    @GetMapping("/belleza/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            bellezaService.delete(id);
        }
        return "redirect:/belleza/list";
    }
}



