package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;

@Repository
public interface AplicacaoRepository extends CrudRepository<Aplicacao, Integer> {

    @Query("FROM Aplicacao a WHERE a.usuario.id = :id")
    Collection<Aplicacao> obterLista(Integer id);
}
