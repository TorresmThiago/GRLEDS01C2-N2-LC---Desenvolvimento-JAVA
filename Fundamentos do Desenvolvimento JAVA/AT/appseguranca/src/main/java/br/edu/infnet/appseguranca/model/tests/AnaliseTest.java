package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;

public class AnaliseTest {

    public static void main(String[] args) throws Exception {

        Aplicacao aplicacaoTeste = new Aplicacao();
        Analise analiseTeste = new Analise();
        VulnWeb[] vulnerabilidades = new VulnWeb[1];

        aplicacaoTeste.setId(1);
        aplicacaoTeste.setNome("Aplicação de Teste");
        aplicacaoTeste.setDemanda("Teste do método .toString()");
        aplicacaoTeste.setAmbiente("Desenvolvimento");
        aplicacaoTeste.setEndereco("http://localhost:8080");
        aplicacaoTeste.setAnalise(analiseTeste);
        aplicacaoTeste.setVulnerabilidades(vulnerabilidades);

        analiseTeste.setId(1);
        analiseTeste.setTitulo("Análise de Teste");
        analiseTeste.setDescricao("Teste do método .toString() da classe Aplicacao");
        analiseTeste.setCliente("Cliente Imaginário");
        analiseTeste.setQtdHoras(1);
        analiseTeste.setatividade("Teste de funcionalidades");
        analiseTeste.setDataInicio("01/01/2021");
        analiseTeste.setDataFim("01/01/2024");
        analiseTeste.setStatus("Em andamento");
        analiseTeste.setAplicacao(aplicacaoTeste);

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
