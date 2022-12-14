package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;

public class VulnWebTest {

    public static void main(String[] args) {
        VulnWeb vulnWeb = new VulnWeb();
        vulnWeb.setId(1);
        vulnWeb.setNome("Falha no tratamento de login simultâneo");
        vulnWeb.setDescricao(
                "Foi identificado a possibilidade de login simultâneo do mesmo usuário em dispositivos e/ou navegadores diferentes.");
        vulnWeb.setRecomendacao(
                "De acordo com as boas práticas de segurança é recomendável restringir o acesso à aplicação de um mesmo usuário originando de uma origem de cada vez");
        vulnWeb.setImpacto(Constantes.RISCO_BAIXA);
        vulnWeb.setProbabilidade(Constantes.RISCO_MEDIA);
        vulnWeb.setReferencia("https://cheatsheetseries.owasp.org/cheatsheets/Session_Management_Cheat_Sheet.html");
        vulnWeb.setNavegador(Constantes.NAVEGADOR_CHROME);
        vulnWeb.setUrlAfetada(new String[] { "http://localhost:8080/appseguranca/" });
        vulnWeb.setRedeInterna(false);
        vulnWeb.setClassificacaoOWASP(Constantes.CLASSIFICACAO_OWASP_A2);

        System.out.println(vulnWeb.toString());
    }

}
