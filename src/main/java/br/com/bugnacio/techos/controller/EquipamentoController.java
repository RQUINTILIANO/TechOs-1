package br.com.bugnacio.techos.controller;

<<<<<<< HEAD
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bugnacio.techos.model.Equipamento;
import br.com.bugnacio.techos.repository.ClienteRepository;
import br.com.bugnacio.techos.repository.EquipamentoRepository;
import jakarta.validation.Valid;
=======
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 1d77bbadacaa1b9f88ecb00edcb73a63d5c8f9f6

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

<<<<<<< HEAD
    private final EquipamentoRepository repo;
    private final ClienteRepository clienteRepo;
    
    public EquipamentoController(
            EquipamentoRepository repo,
            ClienteRepository clienteRepo) {
        this.repo = repo;
        this.clienteRepo = clienteRepo;
    }
    

    @SuppressWarnings("null")
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "equipamentos",
                repo.findAll(Sort.by(Equipamento::getMarca)));

        return "equipamento/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute(
                "equipamento",
                new Equipamento());

        return "equipamento/form";
    }

    @PostMapping("/salvar")
        public String salvar(
        @Valid Equipamento equipamento,
        BindingResult result,
        RedirectAttributes redirect) {

    if (result.hasErrors()) {
        return "equipamento/form";
    }

    repo.save(equipamento);

    redirect.addFlashAttribute(
            "mensagem",
            "Equipamento salvo com sucesso!");

    return "redirect:/equipamentos";
}
   @PostMapping("/{id}/excluir")
public String excluir(
        @PathVariable Long id,
        RedirectAttributes redirect) {

    repo.deleteById(id);

    redirect.addFlashAttribute(
            "mensagem",
            "Equipamento excluído com sucesso!");

    return "redirect:/equipamentos";
}

    @GetMapping("/{id}/editar")
    public String editar(
            @PathVariable Long id,
            Model model) {

        Equipamento equipamento =
                repo.findById(id).orElseThrow();

        model.addAttribute(
                "equipamento",
                equipamento);

        return "equipamento/form";
    }
=======
    // Endereco: http://localhost:8080/equipamentos
    @GetMapping
    public String listar(Model model) {
        // A tela equipamentos/lista espera uma lista chamada "equipamentos".
        model.addAttribute("equipamentos", List.of());

        // Abre: templates/equipamentos/lista.html
        return "equipamentos/lista";
    }
>>>>>>> 1d77bbadacaa1b9f88ecb00edcb73a63d5c8f9f6
}