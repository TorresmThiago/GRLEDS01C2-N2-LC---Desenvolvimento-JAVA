package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.exceptions.VulnAPIInvalidaException;

public class VulnAPI extends Vulnerabilidade {

    private String host;
    private String requisicao;
    private String metodo;
    private String classificacaoOWASPAPI;

    public VulnAPI(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPAPI,
            String host, String requisicao, String metodo) throws Exception {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia, Constantes.TIPO_VULN_API);

        if (host == null || host.isEmpty()) {
            throw new VulnAPIInvalidaException("Host inválido");
        }

        if (requisicao == null || requisicao.isEmpty()) {
            throw new VulnAPIInvalidaException("Requisição inválida");
        }

        if (metodo == null || metodo.isEmpty() || !Arrays.asList(Constantes.METODOS_HTTP).contains(metodo)) {
            throw new VulnAPIInvalidaException("Método HTTP inválido");
        }

        if (classificacaoOWASPAPI == null || classificacaoOWASPAPI.isEmpty()) {
            throw new VulnAPIInvalidaException("Classificação OWASP API inválida");
        }

        try {

            if (Integer.parseInt(classificacaoOWASPAPI.substring(1, 2)) < 1
                    || Integer.parseInt(classificacaoOWASPAPI.substring(1, 2)) > 10) {
                throw new VulnAPIInvalidaException(
                        "Classificação OWASP API inválida. Favor usar as constantes da classe Constantes");
            }

            this.host = host;
            this.requisicao = requisicao;
            this.metodo = metodo;
            this.classificacaoOWASPAPI = classificacaoOWASPAPI;
        } catch (NumberFormatException e) {
            throw new VulnAPIInvalidaException("Valores designados para a vulnerabilidade não são do tipo esperado");
        }
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

        try {
            sb.append(String.format("Severidade: %s; ", this.calcularSeveridade()));
        } catch (VulnAPIInvalidaException e) {
            sb.append(String.format("Severidade: %s;", e.getMessage()));
        }

        sb.append(String.format("Host: %s; ", this.getHost()));
        sb.append(String.format("Requisição: %s; ", this.getRequisicao()));
        sb.append(String.format("Método: %s; ", this.getMetodo()));
        sb.append(String.format("Classificação OWASP API: %s; ", this.getClassificacaoOWASPAPI()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String calcularSeveridade() throws VulnAPIInvalidaException {
        try {
            int severidade = this.getImpacto() * this.getProbabilidade();
            String classificacao = this.getClassificacaoOWASPAPI();

            if ((severidade == 1)
                    && (Arrays.asList(Constantes.CLASSIFICACAO_OWASP_API_CRITICA).contains(classificacao))) {
                return Constantes.SEVERIDADE_CRITICA;
            } else if (severidade <= 2) {
                return Constantes.SEVERIDADE_ALTA;
            } else if (severidade <= 4) {
                return Constantes.SEVERIDADE_MEDIA;
            } else if (severidade <= 6) {
                return Constantes.SEVERIDADE_BAIXA;
            } else {
                throw new VulnAPIInvalidaException("Valores de impacto e probabilidade inválidos");
            }
        } catch (VulnAPIInvalidaException e) {
            throw new VulnAPIInvalidaException("Erro ao tentar calcular a severidade da vulnerabilidade");
        }
    }
}
