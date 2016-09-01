package br.com.transportadora.controller;

import br.com.transportadora.model.Usuario;
import br.com.transportadora.service.CrudService;
import br.com.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by João on 23/08/2016.
 */

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario, Long> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected CrudService<Usuario, Long> getService() {
        return this.usuarioService;
    }

    @Override
    public List<Usuario> get() {
        return null;
    }

    @RequestMapping(value = "logado", method = RequestMethod.GET)
    public Usuario usuarioLogado() {
        return this.usuarioService.usuarioLogado();
    }
}
