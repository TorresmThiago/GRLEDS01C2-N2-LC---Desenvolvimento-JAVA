package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.exceptions.VulnWebInvalidaException;

public class VulnWebTest {

    public static void main(String[] args) throws Exception {

        String nome = "Falha no tratamento de login simultâneo";
        String descricao = "Foi identificado a possibilidade de login simultâneo do mesmo usuário em dispositivos e/ou navegadores diferentes.";
        String recomendacao = "De acordo com as boas práticas de segurança é recomendável restringir o acesso à aplicação de um mesmo usuário originando de uma origem de cada vez";
        String referencia = "https://cheatsheetseries.owasp.org/cheatsheets/Session_Management_Cheat_Sheet.html";
        String[] urlAfetada = new String[] { "http://localhost:8080/appseguranca/" };

        VulnWeb vulnWeb;
        try {
            vulnWeb = new VulnWeb(1, nome, descricao, recomendacao, Constantes.RISCO_BAIXA, Constantes.RISCO_MEDIA,
                    referencia, Constantes.NAVEGADOR_CHROME, urlAfetada, false, Constantes.CLASSIFICACAO_OWASP_A2);

            System.out.println(vulnWeb.toString());

            String severidadeVuln = vulnWeb.calcularSeveridade();
            System.out.println("Severidade da vulnerabilidade: " + severidadeVuln);

        } catch (VulnWebInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }

}
