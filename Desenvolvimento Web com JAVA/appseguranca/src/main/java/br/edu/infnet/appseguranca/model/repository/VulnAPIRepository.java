package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;

@Repository
public interface VulnAPIRepository extends CrudRepository<VulnAPI, Integer> {

    @Query("from VulnAPI v where v.usuario.id = :userId")
    public Collection<VulnAPI> obterLista(Integer userId);
}
