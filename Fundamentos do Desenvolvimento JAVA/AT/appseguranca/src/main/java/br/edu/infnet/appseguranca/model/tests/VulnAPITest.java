package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.VulnAPI;

public class VulnAPITest {

    public static void main(String[] args) {

        VulnAPI vulnAPI = new VulnAPI();
        vulnAPI.setId(1);
        vulnAPI.setNome("Ausência de taxa limite de requisições");
        vulnAPI.setDescricao(
                "A aplicação não possui taxa limite de requisições. Isto permite que um usuário malicioso faça inúmeras requisições à API, dentro de um curto período de tempo, possibilitando o esgotamento dos recursos");
        vulnAPI.setRecomendacao(
                "Implementação mecanismos de proteção contra ataques de força bruta, tais como o mecanismo de CAPTCHA e o bloqueio temporário do usuário.");
        vulnAPI.setImpacto(Constantes.RISCO_ALTA);
        vulnAPI.setProbabilidade(Constantes.RISCO_MEDIA);
        vulnAPI.setReferencia(
                "https://owasp.org/www-community/controls/Blocking_Brute_Force_Attacks#sidebar-using-captchas");
        vulnAPI.setClassificacaoOWASPAPI(Constantes.CLASSIFICACAO_OWASP_API_A7);
        vulnAPI.setHost("http://localhost:8080");
        vulnAPI.setRequisicao("/api/v1/usuarios");
        vulnAPI.setMetodo("GET");

        System.out.println(vulnAPI.toString());

        String severidadeVuln = vulnAPI.calcularSeveridade();
        System.out.println("Severidade da vulnerabilidade: " + severidadeVuln);

    }

}
