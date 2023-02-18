package br.edu.infnet.appseguranca.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.UsuarioRepository;
import io.micrometer.core.ipc.http.HttpSender.Request;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista() {
        List<Usuario> lista = UsuarioRepository.obterLista();

        System.out.println("Quantidade de usuários = " + lista.size());

        for (Usuario user : lista) {
            System.out.printf("%s - %s\n", user.getNome(), user.getEmail());
        }

        // Request.setAttribute("lista", lista);

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        UsuarioRepository.incluir(usuario);
        return "redirect:/usuario/lista";
    }
}
