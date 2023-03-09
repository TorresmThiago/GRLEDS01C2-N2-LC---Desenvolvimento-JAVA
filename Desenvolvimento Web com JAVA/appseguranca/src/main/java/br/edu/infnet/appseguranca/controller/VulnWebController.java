package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.service.VulnWebService;

@Controller
public class VulnWebController {

    @Autowired
    private VulnWebService VulnWebService;

    @GetMapping(value = "/vulnweb/cadastro")
    public String telaCadastro() {
        return "vulnWeb/cadastro";
    }

    @GetMapping(value = "/vulnweb/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnwebs", VulnWebService.obterLista());
        return "vulnWeb/lista";
    }

    @PostMapping(value = "/vulnweb/incluir")
    public String incluir(VulnWeb vulnweb) {
        VulnWebService.incluir(vulnweb);
        return "redirect:/vulnweb/lista";
    }

    @GetMapping(value = "/vulnweb/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        VulnWebService.excluir(id);
        return "redirect:/vulnweb/lista";
    }

    @PostMapping(value = "/vulnweb/alterar")
    public String alterar(VulnWeb vulnweb) {
        VulnWebService.alterar(vulnweb);
        return "redirect:/vulnweb/lista";
    }
}
