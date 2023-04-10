package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;
import br.edu.infnet.appseguranca.model.repository.VulnerabilidadeRepository;

@Service
public class VulnerabilidadeService {

    @Autowired
    private VulnerabilidadeRepository vulnerabilidadeRepository;

    public void excluir(Integer id) {
        vulnerabilidadeRepository.deleteById(id);
    }

    public Collection<Vulnerabilidade> obterLista() {
        return (Collection<Vulnerabilidade>) vulnerabilidadeRepository.obterLista(Sort.by(Direction.ASC, "nome"));
    }

    public Collection<Vulnerabilidade> obterLista(Integer id) {
        return vulnerabilidadeRepository.obterLista(id, Sort.by(Direction.ASC, "nome"));
    }

    public Vulnerabilidade obterPorId(Integer id) {
        return vulnerabilidadeRepository.findById(id).orElse(null);
    }
}
