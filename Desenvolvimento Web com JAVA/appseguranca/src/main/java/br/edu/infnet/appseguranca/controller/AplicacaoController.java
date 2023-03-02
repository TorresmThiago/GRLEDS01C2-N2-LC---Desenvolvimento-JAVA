package br.edu.infnet.appseguranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.repository.AplicacaoRepository;

@Controller
public class AplicacaoController {

    @GetMapping(value = "/aplicacao/cadastro")
    public String telaCadastro() {
        return "aplicacao/cadastro";
    }

    @GetMapping(value = "/aplicacao/lista")
    public String telaLista(Model model) {
        model.addAttribute("aplicacoes", AplicacaoRepository.obterLista());
        return "aplicacao/lista";
    }

    @PostMapping(value = "/aplicacao/incluir")
    public String incluir(Aplicacao aplicacao) {
        AplicacaoRepository.incluir(aplicacao);
        return "redirect:/aplicacao/lista";
    }

    @GetMapping(value = "/aplicacao/excluir")
    public String excluir(@PathVariable Integer id) {
        AplicacaoRepository.excluir(id);
        return "redirect:/aplicacao/lista";
    }

    @PostMapping(value = "/aplicacao/alterar")
    public String alterar(Aplicacao aplicacao) {
        AplicacaoRepository.alterar(aplicacao);
        return "redirect:/aplicacao/lista";
    }

}
