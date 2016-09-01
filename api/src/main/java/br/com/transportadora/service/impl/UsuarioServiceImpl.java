package br.com.transportadora.service.impl;

import br.com.transportadora.model.Usuario;
import br.com.transportadora.repository.CrudRepository;
import br.com.transportadora.repository.UsuarioRepository;
import br.com.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by João on 23/08/2016.
 */

@Service
@Transactional
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected CrudRepository<Usuario, Long> getRepository() {
        return this.usuarioRepository;
    }

    @Override
    @Cacheable("UsuarioServiceImpl-usuarioLogado")
    public Usuario usuarioLogado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = this.usuarioRepository.findByEmail(email).get();
        //usuario.getGrupos().size();
        return usuario;
    }
}
