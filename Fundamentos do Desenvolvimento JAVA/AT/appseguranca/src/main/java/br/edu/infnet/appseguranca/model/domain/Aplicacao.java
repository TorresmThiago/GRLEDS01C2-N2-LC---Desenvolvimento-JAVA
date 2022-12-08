package br.edu.infnet.appseguranca.model.domain;

public class Aplicacao {

    Analise analise;
    private int id;
    private String nome;
    private String demanda;
    private String ambiente;
    private String endereco;
    private Vulnerabilidade[] vulnerabilidades;

    public Aplicacao() {
    }

    public Aplicacao(Analise analise, int id, String nome, String demanda, String ambiente,
            String endereco, Vulnerabilidade[] vulnerabilidades) {
        this.analise = analise;
        this.id = id;
        this.nome = nome;
        this.demanda = demanda;
        this.ambiente = ambiente;
        this.endereco = endereco;
        this.vulnerabilidades = vulnerabilidades;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
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

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Vulnerabilidade[] getVulnerabilidades() {
        return vulnerabilidades;
    }

    public void setVulnerabilidades(Vulnerabilidade[] vulnerabilidades) {
        this.vulnerabilidades = vulnerabilidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aplicacao: %s [", nome));
        sb.append(String.format("analise = %s; ", analise.getTitulo()));
        sb.append(String.format("ambiente = %s; ", ambiente));
        sb.append(String.format("demanda = %s; ", demanda));
        sb.append(String.format("endereco = %s; ", endereco));
        sb.append(String.format("id = %i; ", id));
        sb.append(String.format("nome = %s; ", nome));
        sb.append("vulnerabilidades= {");

        for (int i = 0; i < vulnerabilidades.length; i++) {
            sb.append(String.format("id = %i; ", vulnerabilidades[i].getId()));
            sb.append(", ");
        }

        sb.append("} ]");
        return sb.toString();
    }

}
