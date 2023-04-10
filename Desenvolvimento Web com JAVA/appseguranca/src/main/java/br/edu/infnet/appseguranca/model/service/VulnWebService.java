package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.repository.VulnWebRepository;

@Service
public class VulnWebService {

    @Autowired
    private VulnWebRepository vulnWebRepository;

    public boolean incluir(VulnWeb vulnWeb) {
        VulnWeb vuln = vulnWebRepository.save(vulnWeb);
        return vuln != null;
    }

    public void excluir(Integer id) {
        vulnWebRepository.deleteById(id);
    }

    public Collection<VulnWeb> obterLista() {
        return (Collection<VulnWeb>) vulnWebRepository.findAll();
    }

    public Collection<VulnWeb> obterLista(Usuario usuario) {
        return (Collection<VulnWeb>) vulnWebRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
    }

    public VulnWeb obterPorId(Integer id) {
        return vulnWebRepository.findById(id).orElse(null);
    }
}
