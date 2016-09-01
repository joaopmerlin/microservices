package br.com.transportadora.model;

import java.io.Serializable;

/**
 * Created by João on 30/08/2016.
 */
public interface CrudModel<ID extends Serializable> extends Serializable {

    ID getId();

    Empresa getEmpresa();
}
