package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;

@Repository
public class AplicacaoRepository {

    private static Integer id = 1;

    private static Map<Integer, Aplicacao> mapaAplicacao = new HashMap<Integer, Aplicacao>();

    public boolean incluir(Aplicacao aplicacao) {

        aplicacao.setId(id++);

        try {
            mapaAplicacao.put(aplicacao.getId(), aplicacao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Aplicacao excluir(Integer key) {
        return mapaAplicacao.remove(key);
    }

    public Collection<Aplicacao> obterLista() {
        return mapaAplicacao.values();
    }

    public Aplicacao obterPorId(Integer key) {
        return mapaAplicacao.get(key);
    }

    public boolean alterar(Aplicacao aplicacao) {
        try {
            mapaAplicacao.put(aplicacao.getId(), aplicacao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
