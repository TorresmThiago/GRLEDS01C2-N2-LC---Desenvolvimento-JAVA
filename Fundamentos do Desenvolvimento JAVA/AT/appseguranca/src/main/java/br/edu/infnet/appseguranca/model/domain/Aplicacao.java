package br.edu.infnet.appseguranca.model.domain;

import java.util.List;

public class Aplicacao {

    private Analise analise;
    private int id;
    private String nome;
    private String demanda;
    private String ambiente;
    private String endereco;
    private List<Vulnerabilidade> vulnerabilidades;

    public Aplicacao() {
    }

    public Aplicacao(Analise analise, int id, String nome, String demanda, String ambiente, String endereco) {
        this.analise = analise;
        this.id = id;
        this.nome = nome;
        this.demanda = demanda;
        this.ambiente = ambiente;
        this.endereco = endereco;
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
        if (id < 0) {
            throw new IllegalArgumentException("Id não pode ser negativo");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        if (demanda == null || demanda.isEmpty()) {
            throw new IllegalArgumentException("Demanda não pode ser nulo ou vazio");
        }
        this.demanda = demanda;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        if (ambiente == null || ambiente.isEmpty()) {
            throw new IllegalArgumentException("Ambiente não pode ser nulo ou vazio");
        }
        this.ambiente = ambiente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }
        this.endereco = endereco;
    }

    public List<Vulnerabilidade> getVulnerabilidades() {
        return vulnerabilidades;
    }

    public void setVulnerabilidades(List<Vulnerabilidade> vulnerabilidades) {
        if (vulnerabilidades == null || vulnerabilidades.size() == 0) {
            throw new IllegalArgumentException("Vulnerabilidades não pode ser nulo ou vazio");
        }
        this.vulnerabilidades = vulnerabilidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Nome da Aplicação: %s; ", nome));
        sb.append(String.format("Análise = %s; ", analise.getTitulo()));
        sb.append(String.format("Ambiente = %s; ", ambiente));
        sb.append(String.format("Demanda = %s; ", demanda));
        sb.append(String.format("Endereco = %s; ", endereco));
        sb.append(String.format("Id = %d; ", id));
        sb.append(String.format("Total de vulnerabilidades: %d {\r\n", vulnerabilidades.size()));

        for (int i = 0; i < vulnerabilidades.size(); i++) {
            sb.append(String.format("(%s) %d: %s; ", vulnerabilidades.get(i).getTipo(), i + 1,
                    vulnerabilidades.get(i).getNome()));
            sb.append("\r\n");
        }

        sb.append("} ]");
        return sb.toString();
    }

}
