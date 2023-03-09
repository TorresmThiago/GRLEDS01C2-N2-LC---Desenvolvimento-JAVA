package br.edu.infnet.appseguranca.model.repository;

import br.edu.infnet.appseguranca.model.domain.Usuario;

public class AcessoRepository {

    public static Usuario autenticar(Usuario usuario) {

        if (usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
            return new Usuario("Temporario", usuario.getEmail(), usuario.getSenha());
        }

        return null;
    }
}