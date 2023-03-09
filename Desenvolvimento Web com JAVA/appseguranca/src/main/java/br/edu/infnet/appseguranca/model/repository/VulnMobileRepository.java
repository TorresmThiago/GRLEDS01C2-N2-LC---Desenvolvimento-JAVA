package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;

public class VulnMobileRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnMobile> mapaVulnMobile = new HashMap<Integer, VulnMobile>();

    public boolean incluir(VulnMobile vulnMobile) {

        vulnMobile.setId(id++);

        try {
            mapaVulnMobile.put(vulnMobile.getId(), vulnMobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VulnMobile excluir(Integer key) {
        return mapaVulnMobile.remove(key);
    }

    public Collection<VulnMobile> obterLista() {
        return mapaVulnMobile.values();
    }

    public VulnMobile obterPorId(Integer key) {
        return mapaVulnMobile.get(key);
    }

    public boolean alterar(VulnMobile vulnMobile) {
        try {
            mapaVulnMobile.put(vulnMobile.getId(), vulnMobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
