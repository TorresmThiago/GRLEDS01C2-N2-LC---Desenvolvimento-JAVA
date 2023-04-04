package br.edu.infnet.appseguranca.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.service.AplicacaoService;
import br.edu.infnet.appseguranca.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AplicacaoService aplicacaoService;

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String login, @RequestParam String senha) {
        Usuario user = new Usuario(login, senha);
        user = usuarioService.autenticar(user);

        if (user != null) {
            user.setAplicacoes((List<Aplicacao>) aplicacaoService.obterLista(user.getId()));
            model.addAttribute("usuario", user);
            return "redirect:/home";
        }

        model.addAttribute("mensagem", "Usuário ou senha incorretos!");
        return telaLogin();
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("usuario");
        return "redirect:/";
    }
}