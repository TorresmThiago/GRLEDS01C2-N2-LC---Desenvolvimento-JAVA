package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.service.VulnMobileService;

@Controller
public class VulnMobileController {

    @Autowired
    private VulnMobileService VulnMobileService;

    private String msg;

    @GetMapping(value = "/vulnmobile/cadastro")
    public String telaCadastro() {
        return "vulnMobile/cadastro";
    }

    @GetMapping(value = "/vulnmobile/lista")
    public String telaLista(Model model) {
        model.addAttribute("vulnmobiles", VulnMobileService.obterLista());
        model.addAttribute("msg", msg);
        msg = null;
        return "vulnMobile/lista";
    }

    @PostMapping(value = "/vulnmobile/incluir")
    public String incluir(VulnMobile vulnmobile, @SessionAttribute("usuario") Usuario usuario) {
        vulnmobile.setUsuario(usuario);
        VulnMobileService.incluir(vulnmobile);
        return "redirect:/vulnmobile/lista";
    }

    @GetMapping(value = "/vulnmobile/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id) {
        try {
            VulnMobile vulnerabilidade = VulnMobileService.obterPorId(id);
            if (vulnerabilidade.getAplicacao() == null) {
                VulnMobileService.excluir(id);
            } else {
                msg = "Vulnerabilidade não pode ser excluída pois está associada a uma aplicação!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/vulnmobile/lista";
    }

    // @PostMapping(value = "/vulnmobile/alterar")
    // public String alterar(VulnMobile vulnmobile) {
    // VulnMobileService.alterar(vulnmobile);
    // return "redirect:/vulnmobile/lista";
    // }
}
