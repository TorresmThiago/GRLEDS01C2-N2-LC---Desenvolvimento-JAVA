package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.domain.*;
import br.edu.infnet.appseguranca.model.exceptions.*;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;

public class AplicacaoTest {

    public static void main(String[] args) throws Exception {

        Analise analiseTeste = new Analise(1, "Análise de Teste", "Teste do método .toString() da classe Aplicacao",
                "Cliente Imaginário", "Teste de funcionalidades", 1, "01/01/2021", "01/01/2024", "Em andamento");

        Aplicacao aplicacaoTeste = new Aplicacao(analiseTeste, 1, "Aplicação de Teste", "Teste do método .toString()",
                Constantes.TIPO_AMBIENTE_DESENVOLVIMENTO, "http://localhost:8080");

        List<Vulnerabilidade> vulnerabilidades = new ArrayList<Vulnerabilidade>();

        analiseTeste.setAplicacao(aplicacaoTeste);
        aplicacaoTeste.setVulnerabilidades(vulnerabilidades);

        //
        // Vulnerabilidade Web
        //

        VulnWeb vulnWeb = null;

        try {
            String nome = "Falha no tratamento de login simultâneo";
            String descricao = "Foi identificado a possibilidade de login simultâneo do mesmo usuário em dispositivos e/ou navegadores diferentes.";
            String recomendacao = "De acordo com as boas práticas de segurança é recomendável restringir o acesso à aplicação de um mesmo usuário originando de uma origem de cada vez";
            String referencia = "https://cheatsheetseries.owasp.org/cheatsheets/Session_Management_Cheat_Sheet.html";
            String[] urlAfetada = new String[] { "http://localhost:8080/appseguranca/" };
            vulnWeb = new VulnWeb(1, nome, descricao, recomendacao, Constantes.RISCO_BAIXA, Constantes.RISCO_MEDIA,
                    referencia, Constantes.NAVEGADOR_CHROME, urlAfetada, false, Constantes.CLASSIFICACAO_OWASP_A2);
        } catch (VulnWebInvalidaException e) {
            System.out.println(e.getMessage());
        }

        vulnerabilidades.add(vulnWeb);

        //
        // Vulnerabilidade Mobile
        //

        VulnMobile vulnMobile = null;

        try {
            String nome = "Divulgação de endereço interno";
            String descricao = "Foi encontrado no código fonte do aplicativo uma referência a um endereço interno da rede corporativa.";
            String recomendacao = "Evitar divulgar informações internas do ambiente da aplicação mesmo para usuários com nível de permissão adequado.";
            String referencia = "http://projects.webappsec.org/w/page/13246936/Information%20Leakage";
            String[] pacotesAfetados = new String[] { "br.edu.infnet.appseguranca.constantes",
                    "br.edu.infnet.appseguranca.model" };
            vulnMobile = new VulnMobile(1, nome, descricao, recomendacao, Constantes.RISCO_MEDIA,
                    Constantes.RISCO_MEDIA, referencia, Constantes.CLASSIFICACAO_OWASP_MOBILE_A2,
                    Constantes.SISTEMA_OPERACIONAL_MOBILE_ANDROID, pacotesAfetados);
        } catch (VulnMobileInvalidaException e) {
            System.out.println(e.getMessage());
        }

        vulnerabilidades.add(vulnMobile);

        //
        // Vulnerabilidade API
        //

        VulnAPI vulnAPI = null;
        try {
            String nome = "Ausência de taxa limite de requisições";
            String descricao = "A aplicação não possui taxa limite de requisições. Isto permite que um usuário malicioso faça inúmeras requisições à API, dentro de um curto período de tempo, possibilitando o esgotamento dos recursos";
            String recomendacao = "Implementação mecanismos de proteção contra ataques de força bruta, tais como o mecanismo de CAPTCHA e o bloqueio temporário do usuário.";
            String referencia = "https://owasp.org/www-community/controls/Blocking_Brute_Force_Attacks#sidebar-using-captchas";
            String host = "http://localhost:8080";
            String requisicao = "/api/v1/usuarios";
            String metodo = "GET";
            vulnAPI = new VulnAPI(1, nome, descricao, recomendacao, Constantes.RISCO_ALTA,
                    Constantes.RISCO_MEDIA,
                    referencia, Constantes.CLASSIFICACAO_OWASP_API_A7, host, requisicao, metodo);
        } catch (VulnAPIInvalidaException e) {
            System.out.println(e.getMessage());
        }

        vulnerabilidades.add(vulnAPI);

        System.out.println(aplicacaoTeste.toString());
    }

}
