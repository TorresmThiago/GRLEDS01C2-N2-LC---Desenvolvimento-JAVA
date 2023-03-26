package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.VulnWeb;

@Repository
public interface VulnWebRepository extends CrudRepository<VulnWeb, Integer> {

    @Query("from VulnWeb v where v.usuario.id = :userId")
    public Collection<VulnWeb> obterLista(Integer userId);
}
