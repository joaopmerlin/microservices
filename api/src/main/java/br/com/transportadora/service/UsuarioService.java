package br.com.transportadora.service;

import br.com.transportadora.model.Usuario;

/**
 * Created by João on 23/08/2016.
 */
public interface UsuarioService extends CrudService<Usuario, Long> {

    Usuario usuarioLogado();

}
