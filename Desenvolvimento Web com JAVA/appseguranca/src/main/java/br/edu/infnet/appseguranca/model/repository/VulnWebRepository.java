package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.VulnWeb;

@Repository
public class VulnWebRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnWeb> mapaVulnWeb = new HashMap<Integer, VulnWeb>();

    public boolean incluir(VulnWeb vulnWeb) {

        vulnWeb.setId(id++);

        try {
            mapaVulnWeb.put(vulnWeb.getId(), vulnWeb);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VulnWeb excluir(Integer key) {
        return mapaVulnWeb.remove(key);
    }

    public Collection<VulnWeb> obterLista() {
        return mapaVulnWeb.values();
    }

    public VulnWeb obterPorId(Integer key) {
        return mapaVulnWeb.get(key);
    }

    public boolean alterar(VulnWeb vulnWeb) {
        try {
            mapaVulnWeb.put(vulnWeb.getId(), vulnWeb);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
