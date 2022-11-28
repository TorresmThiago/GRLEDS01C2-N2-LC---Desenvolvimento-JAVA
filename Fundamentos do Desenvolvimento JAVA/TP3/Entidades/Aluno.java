package Entidades;

public class Aluno {

    String nome;
    String sobrenome;
    float notaAV1;
    float notaAV2;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public float getNotaAV1() {
        return notaAV1;
    }

    public void setNotaAV1(float notaAV1) {
        this.notaAV1 = notaAV1;
    }

    public float getNotaAV2() {
        return notaAV2;
    }

    public void setNotaAV2(float notaAV2) {
        this.notaAV2 = notaAV2;
    }

    public float calcularMedia() {
        return (this.notaAV1 + this.notaAV2) / 2;
    }

    public String calcularSituacao() {
        float media = calcularMedia();
        String situacao = "Reprovado";

        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 4 && media < 7) {
            situacao = "Prova final";
        }

        return situacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(this.nome).append(" ").append(this.sobrenome).append(" - ");
        sb.append("AV1: ").append(this.notaAV1).append(" - ");
        sb.append("AV2: ").append(this.notaAV2).append(" - ");
        sb.append("Média: ").append(calcularMedia()).append(" - ");
        sb.append("Situação: ").append(calcularSituacao());
        return sb.toString();
    }
}
