package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;

public interface VulnerabilidadeRepository extends CrudRepository<Vulnerabilidade, Integer> {

    @Query("from Vulnerabilidade v where v.usuario.id = :userId")
    public Collection<Vulnerabilidade> obterLista(Integer userId, Sort sort);

    @Query("from Vulnerabilidade")
    public Collection<Vulnerabilidade> obterLista(Sort sort);
}
