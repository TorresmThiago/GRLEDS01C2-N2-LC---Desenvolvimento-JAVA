package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import br.edu.infnet.appseguranca.model.domain.Analise;

@Repository
public interface AnaliseRepository extends CrudRepository<Analise, Integer> {

    @Query("FROM Analise a WHERE a.usuario.id = :id")
    Collection<Analise> obterLista(Integer id, Sort sort);
}
