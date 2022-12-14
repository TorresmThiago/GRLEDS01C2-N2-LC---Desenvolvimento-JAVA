package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.exceptions.VulnMobileInvalidaException;

public class VulnMobileTest {

    public static void main(String[] args) throws Exception {

        String nome = "Divulgação de endereço interno";
        String descricao = "Foi encontrado no código fonte do aplicativo uma referência a um endereço interno da rede corporativa.";
        String recomendacao = "Evitar divulgar informações internas do ambiente da aplicação mesmo para usuários com nível de permissão adequado.";
        String referencia = "http://projects.webappsec.org/w/page/13246936/Information%20Leakage";
        String[] pacotesAfetados = new String[] { "br.edu.infnet.appseguranca.constantes",
                "br.edu.infnet.appseguranca.model" };

        try {
            VulnMobile vulnMobile = new VulnMobile(1, nome, descricao, recomendacao, Constantes.RISCO_MEDIA,
                    Constantes.RISCO_MEDIA, referencia, Constantes.SISTEMA_OPERACIONAL_MOBILE_ANDROID,
                    Constantes.CLASSIFICACAO_OWASP_MOBILE_A2, pacotesAfetados);

            System.out.println(vulnMobile.toString());

            String severidadeVuln = vulnMobile.calcularSeveridade();
            System.out.println("Severidade da vulnerabilidade: " + severidadeVuln);

        } catch (VulnMobileInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }

}
