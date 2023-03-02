package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.repository.VulnMobileRepository;

@Controller
public class VulnMobileController {

    @GetMapping(value = "/vulnmobile/cadastro")
    public String telaCadastro() {
        return "vulnmobile/cadastro";
    }

    @GetMapping(value = "/vulnmobile/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnmobiles", VulnMobileRepository.obterLista());
        return "vulnmobile/lista";
    }

    @PostMapping(value = "/vulnmobile/incluir")
    public String incluir(VulnMobile vulnmobile) {
        VulnMobileRepository.incluir(vulnmobile);
        return "redirect:/vulnmobile/lista";
    }

    @GetMapping(value = "/vulnmobile/excluir")
    public String excluir(@PathVariable Integer id) {
        VulnMobileRepository.excluir(id);
        return "redirect:/vulnmobile/lista";
    }

    @PostMapping(value = "/vulnmobile/alterar")
    public String alterar(VulnMobile vulnmobile) {
        VulnMobileRepository.alterar(vulnmobile);
        return "redirect:/vulnmobile/lista";
    }
}
