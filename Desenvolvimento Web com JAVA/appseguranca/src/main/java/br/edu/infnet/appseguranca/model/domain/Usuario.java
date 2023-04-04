package br.edu.infnet.appseguranca.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String senha;
    private String endFoto;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Vulnerabilidade> vulnerabilidades;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Aplicacao> aplicacoes;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Vulnerabilidade> getVulnerabilidades() {
        return vulnerabilidades;
    }

    public void setVulnerabilidades(List<Vulnerabilidade> vulnerabilidades) {
        this.vulnerabilidades = vulnerabilidades;
    }

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(List<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public String getEndFoto() {
        return endFoto;
    }

    public void setEndFoto(String endFoto) {
        this.endFoto = endFoto;
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nome=" + nome + "]";
    }
}
