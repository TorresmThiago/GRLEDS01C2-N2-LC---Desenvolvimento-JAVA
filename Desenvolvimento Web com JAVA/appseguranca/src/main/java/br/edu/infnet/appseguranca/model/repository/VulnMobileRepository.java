package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appseguranca.model.domain.VulnMobile;

public class VulnMobileRepository {

    private static Integer id = 1;

    private static Map<Integer, VulnMobile> mapaVulnMobile = new HashMap<Integer, VulnMobile>();

    public static boolean incluir(VulnMobile vulnMobile) {

        vulnMobile.setId(id++);

        try {
            mapaVulnMobile.put(vulnMobile.getId(), vulnMobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static VulnMobile excluir(Integer key) {
        return mapaVulnMobile.remove(key);
    }

    public static Collection<VulnMobile> obterLista() {
        return mapaVulnMobile.values();
    }

    public static VulnMobile obterVulnMobile(Integer key) {
        return mapaVulnMobile.get(key);
    }

    public static boolean alterar(VulnMobile vulnMobile) {
        try {
            mapaVulnMobile.put(vulnMobile.getId(), vulnMobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
