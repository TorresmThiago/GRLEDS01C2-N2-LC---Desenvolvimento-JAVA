package br.edu.infnet.appseguranca.model.domain;

public class Vulnerabilidade {

    private int id;
    private String nome;
    private String descricao;
    private String recomendacao;
    private String ataque;
    private String categoria;
    private int impacto;
    private int probabilidade;
    private String severidade;
    private String referencia;

    public Vulnerabilidade() {
    }

    public Vulnerabilidade(int id, String nome, String descricao, String recomendacao, String ataque, String categoria,
            int impacto, int probabilidade, String severidade, String referencia) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.recomendacao = recomendacao;
        this.ataque = ataque;
        this.categoria = categoria;
        this.impacto = impacto;
        this.probabilidade = probabilidade;
        this.severidade = severidade;
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

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
