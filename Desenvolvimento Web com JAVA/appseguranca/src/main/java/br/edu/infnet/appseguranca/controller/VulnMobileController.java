package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.service.VulnMobileService;

@Controller
public class VulnMobileController {

    @Autowired
    private VulnMobileService VulnMobileService;

    @GetMapping(value = "/vulnmobile/cadastro")
    public String telaCadastro() {
        return "vulnMobile/cadastro";
    }

    @GetMapping(value = "/vulnmobile/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnmobiles", VulnMobileService.obterLista());
        return "vulnMobile/lista";
    }

    @PostMapping(value = "/vulnmobile/incluir")
    public String incluir(VulnMobile vulnmobile) {
        VulnMobileService.incluir(vulnmobile);
        return "redirect:/vulnmobile/lista";
    }

    @GetMapping(value = "/vulnmobile/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        VulnMobileService.excluir(id);
        return "redirect:/vulnmobile/lista";
    }

    // @PostMapping(value = "/vulnmobile/alterar")
    // public String alterar(VulnMobile vulnmobile) {
    // VulnMobileService.alterar(vulnmobile);
    // return "redirect:/vulnmobile/lista";
    // }
}
