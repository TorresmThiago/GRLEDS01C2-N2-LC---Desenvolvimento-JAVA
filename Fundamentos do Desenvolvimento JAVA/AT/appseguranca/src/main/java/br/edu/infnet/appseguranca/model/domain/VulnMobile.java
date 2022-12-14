package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;

public class VulnMobile extends Vulnerabilidade {

    private String sistemaOperacionalMobile;
    private String classificacaoOWASPMobile;
    private String[] pacotesAfetados;

    public VulnMobile() {
        super();
    }

    public VulnMobile(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPMobile,
            String sistemaOperacionalMobile, String[] pacotesAfetados) {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia);
        this.sistemaOperacionalMobile = sistemaOperacionalMobile;
        this.classificacaoOWASPMobile = classificacaoOWASPMobile;
        this.pacotesAfetados = pacotesAfetados;
    }

    public String getSistemaOperacionalMobile() {
        return sistemaOperacionalMobile;
    }

    public void setSistemaOperacionalMobile(String sistemaOperacionalMobile) {
        this.sistemaOperacionalMobile = sistemaOperacionalMobile;
    }

    public String getClassificacaoOWASPMobile() {
        return classificacaoOWASPMobile;
    }

    public void setClassificacaoOWASPMobile(String classificacaoOWASPMobile) {
        this.classificacaoOWASPMobile = classificacaoOWASPMobile;
    }

    public String[] getPacotesAfetados() {
        return pacotesAfetados;
    }

    public void setPacotesAfetados(String[] pacotesAfetados) {
        this.pacotesAfetados = pacotesAfetados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnabilidade Mobile (%d) %s [", this.getId(), this.getNome()));
        sb.append(String.format("Severidade: %s; ", this.calcularSeveridade()));
        sb.append(String.format("SO: %s; ", this.getSistemaOperacionalMobile()));
        sb.append("Pacotes afetados: { ");

        for (int i = 0; i < this.getPacotesAfetados().length; i++) {
            sb.append(String.format("%s", this.getPacotesAfetados()[i]));
            if (i < this.getPacotesAfetados().length - 1) {
                sb.append(", ");
            } else {
                sb.append("}; ");
            }
        }

        sb.append(String.format("Classificação OWASP MOBILE: %s; ", this.getClassificacaoOWASPMobile()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String calcularSeveridade() {
        int severidade = this.getImpacto() * this.getProbabilidade();
        String classificacao = this.getClassificacaoOWASPMobile();

        if ((severidade == 1)
                && (Arrays.asList(Constantes.CLASSIFICACAO_OWASP_MOBILE_CRITICA).contains(classificacao))) {
            return Constantes.SEVERIDADE_CRITICA;
        } else if (severidade <= 2) {
            return Constantes.SEVERIDADE_ALTA;
        } else if (severidade <= 4) {
            return Constantes.SEVERIDADE_MEDIA;
        } else if (severidade <= 6) {
            return Constantes.SEVERIDADE_BAIXA;
        } else {
            throw new IllegalArgumentException("Severidade inválida");
        }
    }

}
