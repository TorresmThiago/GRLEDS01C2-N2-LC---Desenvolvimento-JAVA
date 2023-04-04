package br.edu.infnet.appseguranca.model.domain;

public class EmailReputation {

    private String email;
    private String reputation;
    private Integer references;

    public EmailReputation() {
    }

    public Integer getReferences() {
        return references;
    }

    public void setReferences(Integer references) {
        this.references = references;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        if (references == 0) {
            return "O e-mail " + email
                    + " não foi encontrado em nenhum vazamento de dados. Entretanto, considere usar uma senha forte!";
        } else {
            return "O e-mail " + email + " foi encontrado em " + references
                    + " vazamentos de dados e tem uma reputação " + reputation
                    + ". Considere usar uma senha forte e diferente para cada serviço que você registrar esse email!";
        }
    }
}
