package br.edu.infnet.appseguranca.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAnalise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descricao;
    private String cliente;
    private String atividade;
    private int qtdHoras;
    private String dataInicio;
    private String dataFim;
    private String status;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "idAnalise")
    private List<Aplicacao> aplicacoes;

    public Analise() {
    }

    public Analise(String titulo, String descricao, String cliente, String atividade,
            int qtdHoras, String dataInicio, String dataFim, String status) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(List<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Análise: %s [id = %d; ", titulo, id));
        // sb.append(String.format("Título = %s; ", titulo));
        sb.append(String.format("Descrição = %s; ", descricao));
        sb.append(String.format("Cliente = %s; ", cliente));
        // sb.append(String.format("Aplicação = %s; ", aplicacao.getNome()));
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
        // sb.append(String.format("Aplicacao %d: %s; ", aplicacao.getId(),
        // aplicacao.getNome()));
        // sb.append(String.format("Numero de vulnerabilidades: %d; ",
        // aplicacao.getVulnerabilidades().size()));
        // sb.append(String.format("Status da analise: %s", status));
        return sb.toString();

    }

}
