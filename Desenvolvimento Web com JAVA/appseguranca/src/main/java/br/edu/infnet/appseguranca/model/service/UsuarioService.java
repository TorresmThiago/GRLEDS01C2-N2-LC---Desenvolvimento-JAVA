package br.edu.infnet.appseguranca.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(Usuario usuario) {
        return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha());
    }

    public boolean incluir(Usuario usuario) {
        Usuario u = usuarioRepository.save(usuario);
        return u != null;
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Collection<Usuario> obterLista() {
        return usuarioRepository.obterLista(Sort.by(Direction.ASC, "nome"));
    }

    public Optional<Usuario> obterPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

}
