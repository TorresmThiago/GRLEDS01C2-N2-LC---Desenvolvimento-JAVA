package br.edu.infnet.appseguranca.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;
import br.edu.infnet.appseguranca.model.service.AnaliseService;
import br.edu.infnet.appseguranca.model.service.AplicacaoService;
import br.edu.infnet.appseguranca.model.service.VulnerabilidadeService;

@Controller
public class AplicacaoController {

    @Autowired
    private AplicacaoService aplicacaoService;

    @Autowired
    private AnaliseService analiseService;

    @Autowired
    private VulnerabilidadeService vulnerabilidadeService;

    @GetMapping(value = "/aplicacao/cadastro")
    public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
        Collection<Analise> analises = analiseService.obterLista(usuario.getId());
        if (analises.isEmpty()) {
            model.addAttribute("msg", "É necessário cadastrar uma análise antes de cadastrar uma aplicação.");
        } else {
            model.addAttribute("analises", analiseService.obterLista(usuario.getId()));
        }

        Collection<Vulnerabilidade> vulnerabilidades = vulnerabilidadeService.obterLista(usuario.getId());
        if (vulnerabilidades.isEmpty()) {
            model.addAttribute("msg", "É necessário cadastrar uma vulnerabilidade antes de cadastrar uma aplicação.");
        } else {
            model.addAttribute("vulnerabilidades", vulnerabilidadeService.obterLista(usuario.getId()));
        }

        return "aplicacao/cadastro";
    }

    @GetMapping(value = "/aplicacao/lista")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        model.addAttribute("aplicacoes", aplicacaoService.obterLista(usuario.getId()));
        return "aplicacao/lista";
    }

    @PostMapping(value = "/aplicacao/incluir")
    public String incluir(Aplicacao aplicacao, @SessionAttribute("usuario") Usuario usuario) {
        aplicacao.setUsuario(usuario);
        aplicacaoService.incluir(aplicacao);
        return "redirect:/aplicacao/lista";
    }

    @GetMapping(value = "/aplicacao/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        aplicacaoService.excluir(id);
        return "redirect:/aplicacao/lista";
    }

    @PostMapping(value = "/aplicacao/alterar")
    public String alterar(Aplicacao aplicacao) {
        aplicacaoService.alterar(aplicacao);
        return "redirect:/aplicacao/lista";
    }

}
