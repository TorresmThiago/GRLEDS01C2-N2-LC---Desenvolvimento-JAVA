package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.repository.VulnMobileRepository;

@Service
public class VulnMobileService {

    @Autowired
    private VulnMobileRepository vulnMobileRepository;

    public boolean incluir(VulnMobile vulnMobile) {
        return vulnMobileRepository.incluir(vulnMobile);
    }

    public void excluir(Integer id) {
        vulnMobileRepository.excluir(id);
    }

    public Collection<VulnMobile> obterLista() {
        return vulnMobileRepository.obterLista();
    }

    public VulnMobile obterPorId(Integer id) {
        return vulnMobileRepository.obterPorId(id);
    }

    public void alterar(VulnMobile vulnMobile) {
        vulnMobileRepository.alterar(vulnMobile);
    }
}
