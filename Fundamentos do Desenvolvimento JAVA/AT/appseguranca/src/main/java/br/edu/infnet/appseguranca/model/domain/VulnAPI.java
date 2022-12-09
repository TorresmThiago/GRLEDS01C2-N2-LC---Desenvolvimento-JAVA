package br.edu.infnet.appseguranca.model.domain;

public class VulnAPI extends Vulnerabilidade {

    private String host;
    private String requisicao;
    private String metodo;
    private String classificacaoOWASPAPI;

    public VulnAPI(int id, String nome, String descricao, String recomendacao, String ataque, String categoria,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPAPI,
            String host, String requisicao, String metodo) {
        super(id, nome, descricao, recomendacao, ataque, categoria, impacto, probabilidade, referencia);
        this.host = host;
        this.requisicao = requisicao;
        this.metodo = metodo;
        this.classificacaoOWASPAPI = classificacaoOWASPAPI;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(String requisicao) {
        this.requisicao = requisicao;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getClassificacaoOWASPAPI() {
        return classificacaoOWASPAPI;
    }

    public void setClassificacaoOWASPAPI(String classificacaoOWASPAPI) {
        this.classificacaoOWASPAPI = classificacaoOWASPAPI;
    }

    @Override
    public String toString() {
        return "VulnAPI [host=" + host + ", requisicao=" + requisicao + ", metodo=" + metodo
                + ", classificacaoOWASPAPI="
                + classificacaoOWASPAPI + "]";
    }

    @Override
    public String getSeveridade() {
        return "";
    }
}
