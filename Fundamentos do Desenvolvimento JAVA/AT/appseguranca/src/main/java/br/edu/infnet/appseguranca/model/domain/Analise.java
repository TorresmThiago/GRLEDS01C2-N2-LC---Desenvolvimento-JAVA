package br.edu.infnet.appseguranca.model.domain;

public class Analise {

    private int id;
    private String titulo;
    private String descricao;
    private String cliente;
    private Aplicacao aplicacao;
    private String demanda;
    private int qtdHoras;
    private String dataInicio;
    private String dataFim;
    private String status;

    public Analise(int id, String titulo, String descricao, String cliente, Aplicacao aplicacao, String demanda,
            int qtdHoras, String dataInicio, String dataFim, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cliente = cliente;
        this.aplicacao = aplicacao;
        this.demanda = demanda;
        this.qtdHoras = qtdHoras;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Analise{id=").append(id);
        sb.append(", titulo=").append(titulo);
        sb.append(", descricao=").append(descricao);
        sb.append(", cliente=").append(cliente);
        sb.append(", aplicacao=").append(aplicacao);
        sb.append(", demanda=").append(demanda);
        sb.append(", qtdHoras=").append(qtdHoras);
        sb.append(", dataInicio=").append(dataInicio);
        sb.append(", dataFim=").append(dataFim);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

}
