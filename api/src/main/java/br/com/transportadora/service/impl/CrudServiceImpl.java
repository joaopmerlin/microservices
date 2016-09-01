package br.com.transportadora.service.impl;

import br.com.transportadora.model.CrudModel;
import br.com.transportadora.repository.CrudRepository;
import br.com.transportadora.service.CrudService;
import br.com.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by João on 22/08/2016.
 */

@Component
public abstract class CrudServiceImpl<T extends CrudModel, ID extends Serializable> implements CrudService<T, ID> {

    /*@Autowired
    private UsuarioService usuarioService;

    private Usuario getUsuario() {
        return this.usuarioService.usuarioLogado();
    }*/

    protected abstract CrudRepository<T, ID> getRepository();

    @Override
    public T save(T entidade) {
        return getRepository().save(entidade);
    }

    @Override
    public List<T> save(List<T> entidade) {
        return getRepository().save(entidade);
    }

    @Override
    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public List<T> findAll() {
        /*if (getUsuario().getEmpresa() != null) {
            return getRepository().findByEmpresa(getUsuario().getEmpresa());
        }*/
        return getRepository().findAll();
    }

    @Override
    public void remove(T entidade) {
        getRepository().delete(entidade);
    }

    @Override
    public void remove(ID id) {
        getRepository().delete(id);
    }
}
