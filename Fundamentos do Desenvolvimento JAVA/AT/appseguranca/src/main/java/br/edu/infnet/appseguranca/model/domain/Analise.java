package br.edu.infnet.appseguranca.model.domain;

public class Analise {

    private int id;
    private String titulo;
    private String descricao;
    private String cliente;
    private Aplicacao aplicacao;
    private String atividade;
    private int qtdHoras;
    private String dataInicio;
    private String dataFim;
    private String status;

    public Analise(int id, String titulo, String descricao, String cliente, String atividade,
            int qtdHoras, String dataInicio, String dataFim, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cliente = cliente;
        this.atividade = atividade;
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

    public String getatividade() {
        return atividade;
    }

    public void setatividade(String atividade) {
        this.atividade = atividade;
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
        sb.append(String.format("Análise: %s [id = %d; ", titulo, id));
        // sb.append(String.format("Título = %s; ", titulo));
        sb.append(String.format("Descrição = %s; ", descricao));
        sb.append(String.format("Cliente = %s; ", cliente));
        sb.append(String.format("Aplicação = %s; ", aplicacao.getNome()));
        sb.append(String.format("Atividade = %s; ", atividade));
        sb.append(String.format("Qtd. Horas = %d; ", qtdHoras));
        sb.append(String.format("Data Início = %s; ", dataInicio));
        sb.append(String.format("Data Fim = %s; ", dataFim));
        sb.append(String.format("Status = %s]", status));
        return sb.toString();
    }

    public String obterLinha() {
        // No arquivo gerado precisamos ter um atributo da classe principal, um atributo
        // da classe de associação, a quantidade de objetos da classe mãe.
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Analise %d: %s;", id, titulo));
        sb.append(String.format("Aplicacao %d: %s; ", aplicacao.getId(), aplicacao.getNome()));
        sb.append(String.format("Numero de vulnerabilidades: %d; ", aplicacao.getVulnerabilidades().length));
        sb.append(String.format("Status da analise: %s", status));
        return sb.toString();

    }

}
