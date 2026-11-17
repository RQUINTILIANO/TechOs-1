package br.com.bugnacio.techos.controller;

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
import br.com.bugnacio.techos.repository.EquipamentoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository repo;

    public EquipamentoController(EquipamentoRepository repo) {
        this.repo = repo;
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
}