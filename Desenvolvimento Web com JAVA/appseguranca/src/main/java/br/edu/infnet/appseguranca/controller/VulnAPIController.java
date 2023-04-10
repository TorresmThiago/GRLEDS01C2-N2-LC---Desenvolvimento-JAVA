package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.service.VulnAPIService;

@Controller
public class VulnAPIController {

    @Autowired
    private VulnAPIService vulnAPIService;

    private String msg;

    @GetMapping(value = "/vulnapi/cadastro")
    public String telaCadastro() {
        return "vulnAPI/cadastro";
    }

    @GetMapping(value = "/vulnapi/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnapis", vulnAPIService.obterLista());
        model.addAttribute("msg", msg);
        msg = null;
        return "vulnAPI/lista";
    }

    @PostMapping(value = "/vulnapi/incluir")
    public String incluir(VulnAPI vulnapi, @SessionAttribute("usuario") Usuario usuario) {
        vulnapi.setUsuario(usuario);
        vulnAPIService.incluir(vulnapi);
        return "redirect:/vulnapi/lista";
    }

    @GetMapping(value = "/vulnapi/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id) {
        try {
            VulnAPI vulnerabilidade = vulnAPIService.obterPorId(id);
            if (vulnerabilidade.getAplicacao() == null) {
                vulnAPIService.excluir(id);
            } else {
                msg = "Vulnerabilidade não pode ser excluída pois está associada a uma aplicação!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/vulnapi/lista";
    }

}
