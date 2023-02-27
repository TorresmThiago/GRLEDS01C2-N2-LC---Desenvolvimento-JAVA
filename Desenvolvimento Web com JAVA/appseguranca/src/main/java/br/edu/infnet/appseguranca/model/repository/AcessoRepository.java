package br.edu.infnet.appseguranca.model.repository;

import java.util.Collection;

import br.edu.infnet.appseguranca.model.domain.Usuario;

public class AcessoRepository {

    public static Usuario autenticar(Usuario usuario) {

        String credencial = usuario.getEmail() + ":" + usuario.getSenha();
        Collection<Usuario> lista = UsuarioRepository.obterLista();

        if (lista.isEmpty()) {
            if (usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
                return new Usuario("Temporario", usuario.getEmail(), usuario.getSenha());
            }
        }

        for (Usuario user : lista) {
            if (credencial.equals(user.getEmail() + ":" + user.getSenha())) {
                return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
            }
        }

        return null;
    }
}