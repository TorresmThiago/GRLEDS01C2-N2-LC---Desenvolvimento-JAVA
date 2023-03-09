package br.edu.infnet.appseguranca.model.domain;

import br.edu.infnet.appseguranca.model.exceptions.*;

public abstract class Vulnerabilidade {

    private int id;
    private String nome;
    private String descricao;
    private String recomendacao;
    private int impacto;
    private int probabilidade;
    private String referencia;
    private String tipo;

    public Vulnerabilidade() {
    }

    public Vulnerabilidade(int id, String nome, String descricao, String recomendacao,
            int impacto, int probabilidade, String referencia, String tipo)
            throws Exception {

        if (id < 0) {
            throw new VulnerabilidadeInvalidaException("ID inválido");
        }

        if (nome == null || nome.length() == 0) {
            throw new VulnerabilidadeInvalidaException("Nome inválido");
        }

        if (descricao == null || descricao.length() == 0) {
            throw new VulnerabilidadeInvalidaException("Descrição inválida");
        }

        if (recomendacao == null || recomendacao.length() == 0) {
            throw new VulnerabilidadeInvalidaException("Recomendação inválida");
        }

        if (impacto < 0 || impacto > 3) {
            throw new VulnerabilidadeInvalidaException("Impacto inválido");
        }

        if (probabilidade < 0 || probabilidade > 3) {
            throw new VulnerabilidadeInvalidaException("Probabilidade inválida");
        }

        if (referencia == null || referencia.length() == 0) {
            throw new VulnerabilidadeInvalidaException("Referência inválida");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.recomendacao = recomendacao;
        this.impacto = impacto;
        this.probabilidade = probabilidade;
        this.referencia = referencia;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public int getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(int probabilidade) {
        this.probabilidade = probabilidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract String calcularSeveridade()
            throws Exception;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnerabilidade [id = %s; ", id));
        sb.append(String.format("nome = %s; ", nome));
        sb.append(String.format("descricao = %s; ", descricao));
        sb.append(String.format("recomendacao = %s; ", recomendacao));
        sb.append(String.format("impacto = %s; ", impacto));
        sb.append(String.format("probabilidade = %s; ", probabilidade));
        sb.append(String.format("referencia = %s]", referencia));
        return sb.toString();
    }
}
