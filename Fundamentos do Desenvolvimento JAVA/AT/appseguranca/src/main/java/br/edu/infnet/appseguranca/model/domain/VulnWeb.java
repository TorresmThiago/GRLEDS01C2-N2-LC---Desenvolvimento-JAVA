package br.edu.infnet.appseguranca.model.domain;

public class VulnWeb extends Vulnerabilidade {

    private String navegador;
    private String[] urlAfetada;
    private boolean redeInterna;
    private String classificacaoOWASP;

    public VulnWeb() {
        super();
    }

    public VulnWeb(int id, String nome, String descricao, String recomendacao, String ataque, String categoria,
            int impacto, int probabilidade, String referencia,
            String navegador, String[] urlAfetada, boolean redeInterna, String classificacaoOWASP) {
        super(id, nome, descricao, recomendacao, ataque, categoria, impacto, probabilidade, referencia);
        this.navegador = navegador;
        this.urlAfetada = urlAfetada;
        this.redeInterna = redeInterna;
        this.classificacaoOWASP = classificacaoOWASP;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String[] getUrlAfetada() {
        return urlAfetada;
    }

    public void setUrlAfetada(String[] urlAfetada) {
        this.urlAfetada = urlAfetada;
    }

    public boolean isRedeInterna() {
        return redeInterna;
    }

    public void setRedeInterna(boolean redeInterna) {
        this.redeInterna = redeInterna;
    }

    public String getClassificacaoOWASP() {
        return classificacaoOWASP;
    }

    public void setClassificacaoOWASP(String classificacaoOWASP) {
        this.classificacaoOWASP = classificacaoOWASP;
    }

    @Override
    public String toString() {
        return super.toString() + "VulnWeb [navegador=" + navegador + ", urlAfetada=" + urlAfetada + ", redeInterna="
                + redeInterna + ", classificacaoOWASP=" + classificacaoOWASP + "]";
    }

    @Override
    public String getSeveridade() {
        return "";
    }
}
