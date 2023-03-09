package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.repository.AplicacaoRepository;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;

    public boolean incluir(Aplicacao aplicacao) {
        return aplicacaoRepository.incluir(aplicacao);
    }

    public void excluir(Integer id) {
        aplicacaoRepository.excluir(id);
    }

    public Collection<Aplicacao> obterLista() {
        return aplicacaoRepository.obterLista();
    }

    public Aplicacao obterPorId(Integer id) {
        return aplicacaoRepository.obterPorId(id);
    }

    public void alterar(Aplicacao aplicacao) {
        aplicacaoRepository.alterar(aplicacao);
    }
}
