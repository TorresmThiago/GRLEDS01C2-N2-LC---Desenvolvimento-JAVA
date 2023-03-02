package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appseguranca.model.domain.VulnWeb;

public class VulnWebRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnWeb> mapaVulnWeb = new HashMap<Integer, VulnWeb>();

    public static boolean incluir(VulnWeb vulnWeb) {

        vulnWeb.setId(id++);

        try {
            mapaVulnWeb.put(vulnWeb.getId(), vulnWeb);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static VulnWeb excluir(Integer key) {
        return mapaVulnWeb.remove(key);
    }

    public static Collection<VulnWeb> obterLista() {
        return mapaVulnWeb.values();
    }

    public static VulnWeb obterVulnWeb(Integer key) {
        return mapaVulnWeb.get(key);
    }

    public static boolean alterar(VulnWeb vulnWeb) {
        try {
            mapaVulnWeb.put(vulnWeb.getId(), vulnWeb);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
