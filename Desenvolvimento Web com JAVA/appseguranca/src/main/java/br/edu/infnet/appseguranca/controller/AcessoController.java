package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.AcessoRepository;

@Controller
public class AcessoController {

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String login, @RequestParam String senha) {

        Usuario user = new Usuario(login, senha);

        if (AcessoRepository.autenticar(user) != null) {
            return "redirect:/home";
        }

        return "redirect:/login";
    }
}