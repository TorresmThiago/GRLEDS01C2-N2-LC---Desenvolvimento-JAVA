package br.edu.infnet.appseguranca.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appseguranca.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    public Usuario autenticacao(String email, String senha);
}
