package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.service.AnaliseService;

@Controller
public class AnaliseController {

    @Autowired
    private AnaliseService analiseService;

    private String msg;

    @GetMapping(value = "/analise/cadastro")
    public String telaCadastro() {
        return "analise/cadastro";
    }

    @GetMapping(value = "/analise/lista")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        if (usuario.isAdmin()) {
            model.addAttribute("analises", analiseService.obterLista());
        } else {
            model.addAttribute("analises", analiseService.obterLista(usuario.getId()));
        }
        model.addAttribute("msg", msg);
        msg = null;
        return "analise/lista";
    }

    @PostMapping(value = "/analise/incluir")
    public String incluir(Analise analise, @SessionAttribute("usuario") Usuario usuario) {
        analise.setUsuario(usuario);
        analiseService.incluir(analise);
        return "redirect:/analise/lista";
    }

    @GetMapping(value = "/analise/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id) {
        try {
            Analise analise = analiseService.obterPorId(id);
            if (analise.getAplicacoes() != null) {
                msg = "Não é possível excluir uma análise que possui aplicações!";
            } else {
                analiseService.excluir(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/analise/lista";
    }

    @PostMapping(value = "/analise/alterar")
    public String alterar(Analise analise) {
        analiseService.alterar(analise);
        return "redirect:/analise/lista";
    }

}
