package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.exceptions.VulnWebInvalidaException;

public class VulnWeb extends Vulnerabilidade {

    private String navegador;
    private String[] urlAfetada;
    private boolean redeInterna;
    private String classificacaoOWASP;

    public VulnWeb() {
        super();
    }

    public VulnWeb(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia,
            String navegador, String[] urlAfetada, boolean redeInterna, String classificacaoOWASP) throws Exception {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia, Constantes.TIPO_VULN_WEB);

        if (navegador == null || navegador.length() == 0) {
            throw new VulnWebInvalidaException("Navegador inválido, favor usar as constantes da classe Constantes");
        }

        if (urlAfetada == null || urlAfetada.length == 0) {
            throw new VulnWebInvalidaException("URL afetada inválida");
        }

        if (classificacaoOWASP == null || classificacaoOWASP.length() == 0) {
            throw new VulnWebInvalidaException("Classificação OWASP inválida");
        }

        if (Integer.parseInt(classificacaoOWASP.substring(1, 2)) < 1
                || Integer.parseInt(classificacaoOWASP.substring(1, 2)) > 10) {
            throw new VulnWebInvalidaException(
                    "Classificação OWASP inválida. Favor usar as constantes da classe Constantes");
        }

        this.navegador = navegador;
        this.urlAfetada = urlAfetada;
        this.redeInterna = redeInterna;
        this.classificacaoOWASP = classificacaoOWASP;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String[] getUrlAfetada() {
        return urlAfetada;
    }

    public void setUrlAfetada(String[] urlAfetada) {
        this.urlAfetada = urlAfetada;
    }

    public boolean isRedeInterna() {
        return redeInterna;
    }

    public void setRedeInterna(boolean redeInterna) {
        this.redeInterna = redeInterna;
    }

    public String getClassificacaoOWASP() {
        return classificacaoOWASP;
    }

    public void setClassificacaoOWASP(String classificacaoOWASP) {
        this.classificacaoOWASP = classificacaoOWASP;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnabilidade Web (%d) %s [", this.getId(), this.getNome()));

        try {
            sb.append(String.format("Severidade: %s; ", this.calcularSeveridade()));
        } catch (VulnWebInvalidaException e) {
            sb.append(String.format("Severidade: %s;", e.getMessage()));
        }

        sb.append(String.format("Navegador: %s; ", this.getNavegador()));
        sb.append("URL afetada: { ");

        for (int i = 0; i < this.getUrlAfetada().length; i++) {
            sb.append(String.format("%s", this.getUrlAfetada()[i]));
            if (i < this.getUrlAfetada().length - 1) {
                sb.append(", ");
            } else {
                sb.append("}; ");
            }
        }

        sb.append(String.format("Rede interna: %s; ", this.isRedeInterna()));
        sb.append(String.format("Classificação OWASP: %s; ", this.getClassificacaoOWASP()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String calcularSeveridade() throws VulnWebInvalidaException {
        try {
            int severidade = this.getImpacto() * this.getProbabilidade();
            String classificacao = this.getClassificacaoOWASP();

            if ((severidade == 1)
                    && (Arrays.asList(Constantes.CLASSIFICACAO_OWASP_CRITICA).contains(classificacao))) {
                return Constantes.SEVERIDADE_CRITICA;
            } else if (severidade <= 2) {
                return Constantes.SEVERIDADE_ALTA;
            } else if (severidade <= 4) {
                return Constantes.SEVERIDADE_MEDIA;
            } else if (severidade <= 6) {
                return Constantes.SEVERIDADE_BAIXA;
            } else {
                throw new VulnWebInvalidaException("Valores de impacto e probabilidade inválidos");
            }
        } catch (VulnWebInvalidaException e) {
            throw new VulnWebInvalidaException("Erro ao tentar calcular a severidade da vulnerabilidade");
        }
    }
}
