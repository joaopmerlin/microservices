package br.com.transportadora.service.impl;

import br.com.transportadora.model.Grupo;
import br.com.transportadora.repository.CrudRepository;
import br.com.transportadora.repository.GrupoRepository;
import br.com.transportadora.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by João on 23/08/2016.
 */

@Service
@Transactional
public class GrupoServiceImpl extends CrudServiceImpl<Grupo, Long> implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    protected CrudRepository<Grupo, Long> getRepository() {
        return this.grupoRepository;
    }
}
