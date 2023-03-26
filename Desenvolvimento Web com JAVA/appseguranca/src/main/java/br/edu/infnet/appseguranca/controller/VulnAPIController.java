package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.service.VulnAPIService;

@Controller
public class VulnAPIController {

    @Autowired
    private VulnAPIService vulnAPIService;

    @GetMapping(value = "/vulnapi/cadastro")
    public String telaCadastro() {
        return "vulnAPI/cadastro";
    }

    @GetMapping(value = "/vulnapi/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnapis", vulnAPIService.obterLista());
        return "vulnAPI/lista";
    }

    @PostMapping(value = "/vulnapi/incluir")
    public String incluir(VulnAPI vulnapi) {
        vulnAPIService.incluir(vulnapi);
        return "redirect:/vulnapi/lista";
    }

    @GetMapping(value = "/vulnapi/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        vulnAPIService.excluir(id);
        return "redirect:/vulnapi/lista";
    }

    // @PostMapping(value = "/vulnapi/alterar")
    // public String alterar(VulnAPI vulnapi) {
    // vulnAPIService.alterar(vulnapi);
    // return "redirect:/vulnapi/lista";
    // }
}
