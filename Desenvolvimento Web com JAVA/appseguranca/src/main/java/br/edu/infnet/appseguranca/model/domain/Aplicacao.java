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
@Table(name = "TAplicacao")
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String demanda;
    private String ambiente;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idAnalise")
    private Analise analise;

    @OneToMany
    @JoinColumn(name = "idAplicacao")
    private List<Vulnerabilidade> vulnerabilidades;

    public Aplicacao() {
    }

    public Aplicacao(String nome, String demanda, String ambiente, String endereco) {
        this.nome = nome;
        this.demanda = demanda;
        this.ambiente = ambiente;
        this.endereco = endereco;
    }

    public Analise getAnalise() {
        return this.analise;
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
        this.vulnerabilidades = vulnerabilidades;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Nome da Aplicação: %s; ", nome));
        // sb.append(String.format("Análise = %s; ", analise.getTitulo()));
        sb.append(String.format("Ambiente = %s; ", ambiente));
        sb.append(String.format("Demanda = %s; ", demanda));
        sb.append(String.format("Endereco = %s; ", endereco));
        sb.append(String.format("Id = %d; ", id));
        sb.append(String.format("Total de vulnerabilidades: %d {\r\n",
                vulnerabilidades.size()));

        for (int i = 0; i < vulnerabilidades.size(); i++) {
            sb.append(String.format("(%s) %d: %s; ", vulnerabilidades.get(i).getTipo(), i
                    + 1,
                    vulnerabilidades.get(i).getNome()));
            sb.append("\r\n");
        }

        sb.append("} ]");
        return sb.toString();
    }

}
