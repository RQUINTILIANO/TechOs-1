package br.com.bugnacio.techos;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface ClienteController {

    // @GetMapping vazio = o proprio "/clientes".
    // Endereco completo: http://localhost:8080/clientes
    String listar(Model model);

    //Get /clientes/ novo: mostrar o formulario para criar um novo cliente
    String novo(Model model);

}