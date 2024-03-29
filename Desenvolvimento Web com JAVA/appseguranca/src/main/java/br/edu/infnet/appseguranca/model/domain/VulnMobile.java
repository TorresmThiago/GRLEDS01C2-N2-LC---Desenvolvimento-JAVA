package br.edu.infnet.appseguranca.model.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appseguranca.model.auxiliar.Constantes;
import br.edu.infnet.appseguranca.model.exceptions.VulnMobileInvalidaException;

@Entity
@Table(name = "TVulnMobile")
public class VulnMobile extends Vulnerabilidade {

    private String sistemaOperacionalMobile;
    private String classificacaoOWASPMobile;
    private Integer pacotesAfetados;

    public VulnMobile() {
        super();
    }

    public VulnMobile(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPMobile,
            String sistemaOperacionalMobile, Integer pacotesAfetados) throws Exception {
        super(id, nome, descricao, recomendacao, impacto, probabilidade, referencia, Constantes.TIPO_VULN_MOBILE);

        if (sistemaOperacionalMobile == null || sistemaOperacionalMobile.length() == 0) {
            throw new VulnMobileInvalidaException("Sistema operacional inválido");
        }

        if (classificacaoOWASPMobile == null || classificacaoOWASPMobile.length() == 0) {
            throw new VulnMobileInvalidaException("Classificação OWASP inválida");
        }

        if (pacotesAfetados == null || pacotesAfetados == 0) {
            throw new VulnMobileInvalidaException("Pacotes afetados inválidos");
        }

        if (Integer.parseInt(classificacaoOWASPMobile.substring(1, 2)) < 1
                || Integer.parseInt(classificacaoOWASPMobile.substring(1, 2)) > 10) {
            throw new VulnMobileInvalidaException(
                    "Classificação OWASP API inválida. Favor usar as constantes da classe Constantes");
        }

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

    public Integer getPacotesAfetados() {
        return pacotesAfetados;
    }

    public void setPacotesAfetados(Integer pacotesAfetados) {
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
        sb.append("Pacotes afetados: " + this.getPacotesAfetados() + "; ");

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
