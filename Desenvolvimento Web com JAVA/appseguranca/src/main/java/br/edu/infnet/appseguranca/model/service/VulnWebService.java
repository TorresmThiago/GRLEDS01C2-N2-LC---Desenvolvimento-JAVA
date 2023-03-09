package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.repository.VulnWebRepository;

@Service
public class VulnWebService {

    @Autowired
    private VulnWebRepository vulnWebRepository;

    public boolean incluir(VulnWeb vulnWeb) {
        return vulnWebRepository.incluir(vulnWeb);
    }

    public void excluir(Integer id) {
        vulnWebRepository.excluir(id);
    }

    public Collection<VulnWeb> obterLista() {
        return vulnWebRepository.obterLista();
    }

    public VulnWeb obterPorId(Integer id) {
        return vulnWebRepository.obterPorId(id);
    }

    public void alterar(VulnWeb vulnWeb) {
        vulnWebRepository.alterar(vulnWeb);
    }
}
