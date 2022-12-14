package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;

public class VulnMobileTest {

    public static void main(String[] args) {

        VulnMobile vulnMobile = new VulnMobile();
        vulnMobile.setId(1);
        vulnMobile.setNome("Divulgação de endereço interno");
        vulnMobile.setDescricao(
                "Foi encontrado no código fonte do aplicativo uma referência a um endereço interno da rede corporativa.");
        vulnMobile.setRecomendacao(
                "Evitar divulgar informações internas do ambiente da aplicação mesmo para usuários com nível de permissão adequado.");
        vulnMobile.setImpacto(Constantes.RISCO_MEDIA);
        vulnMobile.setProbabilidade(Constantes.RISCO_MEDIA);
        vulnMobile.setReferencia("http://projects.webappsec.org/w/page/13246936/Information%20Leakage");
        vulnMobile.setSistemaOperacionalMobile(Constantes.SISTEMA_OPERACIONAL_MOBILE_ANDROID);
        vulnMobile.setClassificacaoOWASPMobile(Constantes.CLASSIFICACAO_OWASP_MOBILE_A2);
        vulnMobile.setPacotesAfetados(
                new String[] { "br.edu.infnet.appseguranca.constantes", "br.edu.infnet.appseguranca.model" });

        System.out.println(vulnMobile.toString());

        String severidadeVuln = vulnMobile.calcularSeveridade();
        System.out.println("Severidade da vulnerabilidade: " + severidadeVuln);

    }

}
