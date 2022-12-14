package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.exceptions.VulnMobileInvalidaException;

public class VulnMobile extends Vulnerabilidade {

    private String sistemaOperacionalMobile;
    private String classificacaoOWASPMobile;
    private String[] pacotesAfetados;

    public VulnMobile(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPMobile,
            String sistemaOperacionalMobile, String[] pacotesAfetados) throws Exception {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia, Constantes.TIPO_VULN_MOBILE);

        if (sistemaOperacionalMobile == null || sistemaOperacionalMobile.length() == 0) {
            throw new VulnMobileInvalidaException("Sistema operacional inválido");
        }

        if (classificacaoOWASPMobile == null || classificacaoOWASPMobile.length() == 0) {
            throw new VulnMobileInvalidaException("Classificação OWASP inválida");
        }

        if (pacotesAfetados == null || pacotesAfetados.length == 0) {
            throw new VulnMobileInvalidaException("Pacotes afetados inválidos");
        }

        for (String pacote : pacotesAfetados) {
            if (pacote == null || pacote.length() == 0) {
                throw new VulnMobileInvalidaException("Pacotes afetados inválidos");
            }
        }

        try {

            if (Integer.parseInt(classificacaoOWASPMobile.substring(1, 2)) < 1
                    || Integer.parseInt(classificacaoOWASPMobile.substring(1, 2)) > 10) {
                throw new VulnMobileInvalidaException(
                        "Classificação OWASP API inválida. Favor usar as constantes da classe Constantes");
            }

            this.sistemaOperacionalMobile = sistemaOperacionalMobile;
            this.classificacaoOWASPMobile = classificacaoOWASPMobile;
            this.pacotesAfetados = pacotesAfetados;
        } catch (Exception e) {
            throw new VulnMobileInvalidaException("Valores designados para a vulnerabilidade não são do tipo esperado");
        }
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

        try {
            sb.append(String.format("Severidade: %s; ", this.calcularSeveridade()));
        } catch (VulnMobileInvalidaException e) {
            sb.append(String.format("Severidade: %s;", e.getMessage()));
        }

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
    public String calcularSeveridade() throws VulnMobileInvalidaException {
        try {
            int severidade = this.getImpacto() * this.getProbabilidade();
            String classificacao = this.getClassificacaoOWASPMobile();

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
                throw new VulnMobileInvalidaException("Valores de impacto e probabilidade inválidos");
            }
        } catch (VulnMobileInvalidaException e) {
            throw new VulnMobileInvalidaException("Erro ao tentar calcular a severidade da vulnerabilidade");
        }
    }
}
