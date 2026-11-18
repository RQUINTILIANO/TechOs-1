package br.com.bugnacio.techos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> 1d77bbadacaa1b9f88ecb00edcb73a63d5c8f9f6


@Controller 
public class HomeController {
@GetMapping("/")
public String inicio(Model model){
    model.addAttribute("totalClientes",12);
    model.addAttribute("totalEquipamentos", 10);
    model.addAttribute("osAbertas", 3);
    model.addAttribute("osConcluidas", 25);
    model.addAttribute("faturamento", 4850);
    return "dashboard";
}

}