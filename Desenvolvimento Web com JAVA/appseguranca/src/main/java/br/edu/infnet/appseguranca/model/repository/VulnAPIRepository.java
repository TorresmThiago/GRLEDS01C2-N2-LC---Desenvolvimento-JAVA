package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;

public class VulnAPIRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnAPI> mapaVulnAPI = new HashMap<Integer, VulnAPI>();

    public static boolean incluir(VulnAPI vulnAPI) {

        vulnAPI.setId(id++);

        try {
            mapaVulnAPI.put(vulnAPI.getId(), vulnAPI);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static VulnAPI excluir(Integer key) {
        return mapaVulnAPI.remove(key);
    }

    public static Collection<VulnAPI> obterLista() {
        return mapaVulnAPI.values();
    }

    public static VulnAPI obterVulnAPI(Integer key) {
        return mapaVulnAPI.get(key);
    }

    public static boolean alterar(VulnAPI vulnAPI) {
        try {
            mapaVulnAPI.put(vulnAPI.getId(), vulnAPI);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
