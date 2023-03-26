package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.repository.VulnAPIRepository;

@Service
public class VulnAPIService {

    @Autowired
    private VulnAPIRepository vulnAPIRepository;

    public boolean incluir(VulnAPI vulnAPI) {
        VulnAPI vuln = vulnAPIRepository.save(vulnAPI);
        return vuln != null;
    }

    public void excluir(Integer id) {
        vulnAPIRepository.deleteById(id);
    }

    public Collection<VulnAPI> obterLista() {
        return (Collection<VulnAPI>) vulnAPIRepository.findAll();
    }

    public Collection<VulnAPI> obterLista(Usuario usuario) {
        return (Collection<VulnAPI>) vulnAPIRepository.obterLista(usuario.getId());
    }

    public VulnAPI obterPorId(Integer id) {
        return vulnAPIRepository.findById(id).orElse(null);
    }
}
