package br.edu.infnet.appseguranca.model.tests;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;

import org.apache.tomcat.util.bcel.Const;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;

public class AplicacaoTest {

    public static void main(String[] args) {

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

        vulnerabilidades[0] = new VulnWeb();
        vulnerabilidades[0].setId(1);
        vulnerabilidades[0].setNome("Vazamento de informações sensíveis");
        vulnerabilidades[0].setDescricao(
                "Identificamos o vazamento de informações sensíveis na aplicação, tais como endereços internos de rede, senhas, etc.");
        vulnerabilidades[0].setRecomendacao(
                "Qualquer informação sensível, seja endereços IP's, nomes de máquina ou qualquer outra informação que não seja relevante para o aplicativo devem ser retiradas");
        vulnerabilidades[0].setImpacto(1);
        vulnerabilidades[0].setProbabilidade(2);
        vulnerabilidades[0].setNavegador(Constantes.NAVEGADOR_CHROME);
        vulnerabilidades[0].setUrlAfetada(new String[] { "http://localhost:8080/index" });
        vulnerabilidades[0].setRedeInterna(true);
        vulnerabilidades[0].setClassificacaoOWASP(Constantes.CLASSIFICACAO_OWASP_A3);

        System.out.println(aplicacaoTeste.toString());
    }

}
