package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.repository.VulnAPIRepository;

@Service
public class VulnAPIService {

    @Autowired
    private VulnAPIRepository vulnAPIRepository;

    public boolean incluir(VulnAPI vulnAPI) {
        return vulnAPIRepository.incluir(vulnAPI);
    }

    public void excluir(Integer id) {
        vulnAPIRepository.excluir(id);
    }

    public Collection<VulnAPI> obterLista() {
        return vulnAPIRepository.obterLista();
    }

    public VulnAPI obterPorId(Integer id) {
        return vulnAPIRepository.obterPorId(id);
    }

    public void alterar(VulnAPI vulnAPI) {
        vulnAPIRepository.alterar(vulnAPI);
    }
}
