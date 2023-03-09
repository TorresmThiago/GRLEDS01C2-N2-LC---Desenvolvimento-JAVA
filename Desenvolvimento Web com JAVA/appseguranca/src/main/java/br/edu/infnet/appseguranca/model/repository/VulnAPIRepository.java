package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;

@Repository
public class VulnAPIRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnAPI> mapaVulnAPI = new HashMap<Integer, VulnAPI>();

    public boolean incluir(VulnAPI vulnAPI) {

        vulnAPI.setId(id++);

        try {
            mapaVulnAPI.put(vulnAPI.getId(), vulnAPI);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VulnAPI excluir(Integer key) {
        return mapaVulnAPI.remove(key);
    }

    public Collection<VulnAPI> obterLista() {
        return mapaVulnAPI.values();
    }

    public VulnAPI obterPorId(Integer key) {
        return mapaVulnAPI.get(key);
    }

    public boolean alterar(VulnAPI vulnAPI) {
        try {
            mapaVulnAPI.put(vulnAPI.getId(), vulnAPI);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
