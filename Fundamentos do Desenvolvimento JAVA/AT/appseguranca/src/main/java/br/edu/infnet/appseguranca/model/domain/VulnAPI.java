package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;

public class VulnAPI extends Vulnerabilidade {

    private String host;
    private String requisicao;
    private String metodo;
    private String classificacaoOWASPAPI;

    public VulnAPI(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPAPI,
            String host, String requisicao, String metodo) {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia);
        this.host = host;
        this.requisicao = requisicao;
        this.metodo = metodo;
        this.classificacaoOWASPAPI = classificacaoOWASPAPI;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(String requisicao) {
        this.requisicao = requisicao;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getClassificacaoOWASPAPI() {
        return classificacaoOWASPAPI;
    }

    public void setClassificacaoOWASPAPI(String classificacaoOWASPAPI) {
        this.classificacaoOWASPAPI = classificacaoOWASPAPI;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnabilidade API (%d) %s [", this.getId(), this.getNome()));
        sb.append(String.format("Severidade: %s; ", this.calcularSeveridade()));
        sb.append(String.format("Host: %s; ", this.getHost()));
        sb.append(String.format("Requisição: %s; ", this.getRequisicao()));
        sb.append(String.format("Método: %s; ", this.getMetodo()));
        sb.append(String.format("Classificação OWASP API: %s; ", this.getClassificacaoOWASPAPI()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String calcularSeveridade() {
        int severidade = this.getImpacto() * this.getProbabilidade();
        String classificacao = this.getClassificacaoOWASPAPI();

        if ((severidade == 1)
                && (Arrays.asList(Constantes.CLASSIFICACAO_OWASP_API_CRITICA).contains(classificacao))) {
            return "Crítica";
        } else if (severidade <= 1) {
            return "Alta";
        } else if (severidade <= 3) {
            return "Média";
        }

        return "Baixa";
    }
}
