package br.edu.infnet.appseguranca.model.domain;

public class VulnMobile extends Vulnerabilidade {

    private String sistemaOperacionalMobile;
    private String classificacaoOWASPMobile;
    private String[] pacotesAfetados;

    public VulnMobile() {
        super();
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vulnabilidade Mobile (%d) %s [", this.getId(), this.getNome()));
        sb.append(String.format("Severidade: %s; ", this.getSeveridade()));
        sb.append(String.format("SO: %s; ", this.getSistemaOperacionalMobile()));
        sb.append("Pacotes afetados: { ");

        for (int i = 0; i < this.getPacotesAfetados().length; i++) {
            sb.append(String.format("%s", this.getPacotesAfetados()[i]));
            if (i < this.getPacotesAfetados().length - 1) {
                sb.append(", ");
            } else {
                sb.append("}; ");
            }
        }

        sb.append(String.format("Classificação OWASP MOBILE: %s; ", this.getClassificacaoOWASPMobile()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String getSeveridade() {
        int severidade = this.getImpacto() * this.getProbabilidade();
        if (severidade <= 3) {
            return "Baixa";
        } else if (severidade <= 6) {
            return "Média";
        } else if (severidade <= 9) {
            return "Alta";
        } else {
            return "Crítica";
        }
    }

}
