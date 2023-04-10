package br.edu.infnet.appseguranca.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.service.VulnerabilidadeService;

@Controller
public class VulnerabilidadeController {

    @Autowired
    private VulnerabilidadeService vulnerabilidadeService;

    private String msg;

    @GetMapping(value = "/vulnerabilidade/lista")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        if (usuario.isAdmin()) {
            model.addAttribute("vulnerabilidades", vulnerabilidadeService.obterLista());
        } else {
            model.addAttribute("vulnerabilidades", vulnerabilidadeService.obterLista(usuario.getId()));
        }
        model.addAttribute("msg", msg);
        msg = null;
        return "vulnerabilidades";
    }

    @GetMapping(value = "/vulnerabilidade/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id) {
        try {
            Vulnerabilidade vulnerabilidade = vulnerabilidadeService.obterPorId(id);
            if (vulnerabilidade.getAplicacao() == null) {
                vulnerabilidadeService.excluir(id);
            } else {
                msg = "Vulnerabilidade não pode ser excluída pois está associada a uma aplicação!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/vulnerabilidade/lista";
    }
}
