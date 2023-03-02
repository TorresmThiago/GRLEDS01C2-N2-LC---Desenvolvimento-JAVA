package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;

public class AplicacaoRepository {

    private static Integer id = 1;

    private static Map<Integer, Aplicacao> mapaAplicacao = new HashMap<Integer, Aplicacao>();

    public static boolean incluir(Aplicacao aplicacao) {

        aplicacao.setId(id++);

        try {
            mapaAplicacao.put(aplicacao.getId(), aplicacao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Aplicacao excluir(Integer key) {
        return mapaAplicacao.remove(key);
    }

    public static Collection<Aplicacao> obterLista() {
        return mapaAplicacao.values();
    }

    public static Aplicacao obterAplicacao(Integer key) {
        return mapaAplicacao.get(key);
    }

    public static boolean alterar(Aplicacao aplicacao) {
        try {
            mapaAplicacao.put(aplicacao.getId(), aplicacao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
