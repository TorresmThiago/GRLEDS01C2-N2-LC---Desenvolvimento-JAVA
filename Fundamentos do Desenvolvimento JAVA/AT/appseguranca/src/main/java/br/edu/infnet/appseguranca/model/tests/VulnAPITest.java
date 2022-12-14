package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.exceptions.VulnAPIInvalidaException;

public class VulnAPITest {

    public static void main(String[] args) throws Exception {

        String nome = "Ausência de taxa limite de requisições";
        String descricao = "A aplicação não possui taxa limite de requisições. Isto permite que um usuário malicioso faça inúmeras requisições à API, dentro de um curto período de tempo, possibilitando o esgotamento dos recursos";
        String recomendacao = "Implementação mecanismos de proteção contra ataques de força bruta, tais como o mecanismo de CAPTCHA e o bloqueio temporário do usuário.";
        String referencia = "https://owasp.org/www-community/controls/Blocking_Brute_Force_Attacks#sidebar-using-captchas";
        String host = "http://localhost:8080";
        String requisicao = "/api/v1/usuarios";
        String metodo = "GET";

        try {
            VulnAPI vulnAPI = new VulnAPI(1, nome, descricao, recomendacao, Constantes.RISCO_ALTA,
                    Constantes.RISCO_MEDIA,
                    referencia, Constantes.CLASSIFICACAO_OWASP_API_A7, host, requisicao, metodo);

            System.out.println(vulnAPI.toString());

            String severidadeVuln = vulnAPI.calcularSeveridade();
            System.out.println("Severidade da vulnerabilidade: " + severidadeVuln);

        } catch (VulnAPIInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }

}
