package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.repository.AplicacaoRepository;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;

    public boolean incluir(Aplicacao aplicacao) {
        Aplicacao a = aplicacaoRepository.save(aplicacao);
        return a != null;
    }

    public void excluir(Integer id) {
        aplicacaoRepository.deleteById(id);
    }

    public Collection<Aplicacao> obterLista() {
        return (Collection<Aplicacao>) aplicacaoRepository.findAll();
    }

    public Collection<Aplicacao> obterLista(Integer id) {
        return aplicacaoRepository.obterLista(id);
    }

    public Optional<Aplicacao> obterPorId(Integer id) {
        return aplicacaoRepository.findById(id);
    }

    public void alterar(Aplicacao aplicacao) {
        aplicacaoRepository.save(aplicacao);
    }
}
