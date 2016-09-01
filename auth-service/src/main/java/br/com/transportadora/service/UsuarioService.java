package br.com.transportadora.service;

import br.com.transportadora.model.Usuario;

import java.util.Optional;

/**
 * Created by João on 29/08/2016.
 */
public interface UsuarioService {

    Usuario save(Usuario usuario);

    Optional<Usuario> findByEmail(String email);

}
