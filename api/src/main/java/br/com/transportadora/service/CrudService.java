package br.com.transportadora.service;

import br.com.transportadora.model.CrudModel;
import br.com.transportadora.model.Empresa;

import java.io.Serializable;
import java.util.List;

/**
 * Created by João on 22/08/2016.
 */
public interface CrudService<T extends CrudModel, ID extends Serializable> {

    T save(T entidade);

    List<T> save(List<T> entidade);

    T findOne(ID id);

    List<T> findAll();

    void remove(T entidade);

    void remove(ID id);

}
