package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.repository.VulnMobileRepository;

@Service
public class VulnMobileService {

    @Autowired
    private VulnMobileRepository vulnMobileRepository;

    public boolean incluir(VulnMobile vulnMobile) {
        VulnMobile vuln = vulnMobileRepository.save(vulnMobile);
        return vuln != null;
    }

    public void excluir(Integer id) {
        vulnMobileRepository.deleteById(id);
    }

    public Collection<VulnMobile> obterLista() {
        return (Collection<VulnMobile>) vulnMobileRepository.findAll();
    }

    public Collection<VulnMobile> obterLista(Usuario usuario) {
        return (Collection<VulnMobile>) vulnMobileRepository.obterLista(usuario.getId());
    }

    public VulnMobile obterPorId(Integer id) {
        return vulnMobileRepository.findById(id).orElse(null);
    }
}
