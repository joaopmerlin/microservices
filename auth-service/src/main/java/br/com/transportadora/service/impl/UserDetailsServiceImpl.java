package br.com.transportadora.service.impl;

import br.com.transportadora.model.GrupoPrivilegio;
import br.com.transportadora.model.Usuario;
import br.com.transportadora.model.UsuarioGrupo;
import br.com.transportadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by João on 24/06/2016.
 */

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = this.usuarioRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            Usuario usuario = optionalUser.get();
            usuario.getGrupos().stream().map(UsuarioGrupo::getGrupo).forEach(grupo -> grupo.getPrivilegios().stream().map(GrupoPrivilegio::getPrivilegio).collect(Collectors.toList())); // force lazy collection
            return usuario;
        } else {
            throw new UsernameNotFoundException("couldn't find the user " + username);
        }
    }
}
