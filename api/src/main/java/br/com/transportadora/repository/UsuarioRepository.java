package br.com.transportadora.repository;

import br.com.transportadora.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by João on 23/08/2016.
 */

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
