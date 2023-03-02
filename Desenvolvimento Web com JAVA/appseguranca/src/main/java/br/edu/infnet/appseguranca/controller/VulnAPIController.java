package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.repository.VulnAPIRepository;

@Controller
public class VulnAPIController {

    @GetMapping(value = "/vulnapi/cadastro")
    public String telaCadastro() {
        return "vulnapi/cadastro";
    }

    @GetMapping(value = "/vulnapi/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnapis", VulnAPIRepository.obterLista());
        return "vulnapi/lista";
    }

    @PostMapping(value = "/vulnapi/incluir")
    public String incluir(VulnAPI vulnapi) {
        VulnAPIRepository.incluir(vulnapi);
        return "redirect:/vulnapi/lista";
    }

    @GetMapping(value = "/vulnapi/excluir")
    public String excluir(@PathVariable Integer id) {
        VulnAPIRepository.excluir(id);
        return "redirect:/vulnapi/lista";
    }

    @PostMapping(value = "/vulnapi/alterar")
    public String alterar(VulnAPI vulnapi) {
        VulnAPIRepository.alterar(vulnapi);
        return "redirect:/vulnapi/lista";
    }
}
