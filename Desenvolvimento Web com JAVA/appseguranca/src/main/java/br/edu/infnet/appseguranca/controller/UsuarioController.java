package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {
        model.addAttribute("usuarios", UsuarioRepository.obterLista());
        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        UsuarioRepository.incluir(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping(value = "/usuario/excluir")
    public String excluir(@PathVariable Integer id) {
        UsuarioRepository.excluir(id);
        return "redirect:/usuario/lista";
    }
}
