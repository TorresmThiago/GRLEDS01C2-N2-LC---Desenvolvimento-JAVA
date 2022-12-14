package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;

public class AnaliseTest {

    public static void main(String[] args) throws Exception {

        Analise analiseTeste = new Analise(1, "Análise de Teste", "Teste do método .toString() da classe Aplicacao",
                "Cliente Imaginário", "Teste de funcionalidades", 1, "01/01/2021", "01/01/2024", "Em andamento");
        Aplicacao aplicacaoTeste = new Aplicacao(analiseTeste, 1, "Aplicação de Teste", "Teste do método .toString()",
                Constantes.TIPO_AMBIENTE_DESENVOLVIMENTO, "http://localhost:8080");

        analiseTeste.setAplicacao(aplicacaoTeste);
        Vulnerabilidade[] vulnerabilidades = new Vulnerabilidade[1];
        String nome = "Vazamento de informações sensíveis";
        String descricao = "Identificamos o vazamento de informações sensíveis na aplicação, tais como endereços internos de rede, senhas, etc.";
        String recomendacao = "Qualquer informação sensível, seja endereços IP's, nomes de máquina ou qualquer outra informação que não seja relevante para o aplicativo devem ser retiradas";
        String referencia = "https://www.owasp.org/index.php/Information_exposure";
        String[] urlAfetada = new String[] { "http://localhost:8080/index" };

        VulnWeb vulnerabilidadeTeste = new VulnWeb(1, nome, descricao, recomendacao, Constantes.RISCO_ALTA,
                Constantes.RISCO_MEDIA, referencia, Constantes.NAVEGADOR_CHROME, urlAfetada, true,
                Constantes.CLASSIFICACAO_OWASP_A7);

        vulnerabilidades[0] = vulnerabilidadeTeste;

        System.out.println(analiseTeste.toString());
    }
}
