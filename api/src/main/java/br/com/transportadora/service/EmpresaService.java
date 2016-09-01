package br.com.transportadora.service;

import br.com.transportadora.model.Empresa;

/**
 * Created by João on 23/08/2016.
 */
public interface EmpresaService {

    Empresa save(Empresa empresa);

    Empresa find(Long id);

}
