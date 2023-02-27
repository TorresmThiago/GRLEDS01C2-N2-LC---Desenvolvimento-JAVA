package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.AcessoRepository;

@Controller
@SessionAttributes("usuario")
public class AcessoController {

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String login, @RequestParam String senha) {

        Usuario user = new Usuario(login, senha);
        user = AcessoRepository.autenticar(user);

        if (user != null) {
            model.addAttribute("usuario", user);
            return "redirect:/home";
        }

        model.addAttribute("mensagem", "Usuário ou senha incorretos!");
        return telaLogin();
    }
}