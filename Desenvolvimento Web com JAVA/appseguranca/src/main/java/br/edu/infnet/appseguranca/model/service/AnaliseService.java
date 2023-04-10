package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.repository.AnaliseRepository;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository analiseRepository;

    public boolean incluir(Analise analise) {
        Analise a = analiseRepository.save(analise);
        return a != null;
    }

    public void excluir(Integer id) {
        analiseRepository.deleteById(id);
    }

    public Collection<Analise> obterLista() {
        return (Collection<Analise>) analiseRepository.findAll();
    }

    public Collection<Analise> obterLista(Integer id) {
        return analiseRepository.obterLista(id, Sort.by(Direction.ASC, "titulo"));
    }

    public Optional<Analise> obterPorId(Integer id) {
        return analiseRepository.findById(id);
    }

    public void alterar(Analise analise) {
        analiseRepository.save(analise);
    }
}
