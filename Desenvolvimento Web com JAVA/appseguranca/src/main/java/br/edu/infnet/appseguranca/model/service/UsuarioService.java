package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean incluir(Usuario usuario) {
        return usuarioRepository.incluir(usuario);
    }

    public void excluir(Integer id) {
        usuarioRepository.excluir(id);
    }

    public Collection<Usuario> obterLista() {
        return usuarioRepository.obterLista();
    }

    public Usuario obterPorId(Integer id) {
        return usuarioRepository.obterPorId(id);
    }

}
