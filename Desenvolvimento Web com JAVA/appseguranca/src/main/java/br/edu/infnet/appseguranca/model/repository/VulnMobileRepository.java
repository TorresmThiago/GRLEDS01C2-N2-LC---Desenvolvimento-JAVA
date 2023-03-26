package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;

@Repository
public interface VulnMobileRepository extends CrudRepository<VulnMobile, Integer> {

    @Query("from VulnMobile v where v.usuario.id = :userId")
    public Collection<VulnMobile> obterLista(Integer userId);
}
