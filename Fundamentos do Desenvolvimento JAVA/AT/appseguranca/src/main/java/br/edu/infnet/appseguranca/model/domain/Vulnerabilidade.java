package br.edu.infnet.appseguranca.model.domain;

public abstract class Vulnerabilidade {

    private int id;
    private String nome;
    private String descricao;
    private String recomendacao;
    private String ataque;
    private String categoria;
    private int impacto;
    private int probabilidade;
    private String referencia;

    public Vulnerabilidade() {
    }

    public Vulnerabilidade(int id, String nome, String descricao, String recomendacao, String ataque, String categoria,
            int impacto, int probabilidade, String referencia) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.recomendacao = recomendacao;
        this.ataque = ataque;
        this.categoria = categoria;
        this.impacto = impacto;
        this.probabilidade = probabilidade;
        this.referencia = referencia;
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

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public abstract String getSeveridade();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnerabilidade [id = %s; ", id));
        sb.append(String.format("nome = %s; ", nome));
        sb.append(String.format("descricao = %s; ", descricao));
        sb.append(String.format("recomendacao = %s; ", recomendacao));
        sb.append(String.format("ataque = %s; ", ataque));
        sb.append(String.format("categoria = %s; ", categoria));
        sb.append(String.format("impacto = %s; ", impacto));
        sb.append(String.format("probabilidade = %s; ", probabilidade));
        sb.append(String.format("referencia = %s]", referencia));
        return sb.toString();
    }
}
