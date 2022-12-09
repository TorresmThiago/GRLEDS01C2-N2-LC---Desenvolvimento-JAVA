package br.edu.infnet.appseguranca.model.domain;

public class VulnMobile extends Vulnerabilidade {

    private String sistemaOperacionalMobile;
    private String classificacaoOWASPMobile;
    private String[] pacotesAfetados;

    public VulnMobile(int id, String nome, String descricao, String recomendacao, String ataque, String categoria,
            int impacto, int probabilidade, String referencia, String classificacaoOWASPMobile,
            String sistemaOperacionalMobile, String[] pacotesAfetados) {
        super(id, nome, descricao, recomendacao, ataque, categoria, impacto, probabilidade, referencia);
        this.sistemaOperacionalMobile = sistemaOperacionalMobile;
        this.classificacaoOWASPMobile = classificacaoOWASPMobile;
        this.pacotesAfetados = pacotesAfetados;
    }

    public String getSistemaOperacionalMobile() {
        return sistemaOperacionalMobile;
    }

    public void setSistemaOperacionalMobile(String sistemaOperacionalMobile) {
        this.sistemaOperacionalMobile = sistemaOperacionalMobile;
    }

    public String getClassificacaoOWASPMobile() {
        return classificacaoOWASPMobile;
    }

    public void setClassificacaoOWASPMobile(String classificacaoOWASPMobile) {
        this.classificacaoOWASPMobile = classificacaoOWASPMobile;
    }

    public String[] getPacotesAfetados() {
        return pacotesAfetados;
    }

    public void setPacotesAfetados(String[] pacotesAfetados) {
        this.pacotesAfetados = pacotesAfetados;
    }

    @Override
    public String toString() {
        return "VulnMobile [sistemaOperacionalMobile=" + sistemaOperacionalMobile + ", classificacaoOWASPMobile="
                + classificacaoOWASPMobile + ", pacotesAfetados=" + pacotesAfetados + "]";
    }

    @Override
    public String getSeveridade() {
        return "";
    }

}
