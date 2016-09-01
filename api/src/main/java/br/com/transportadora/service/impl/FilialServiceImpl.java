package br.com.transportadora.service.impl;

import br.com.transportadora.model.Filial;
import br.com.transportadora.repository.CrudRepository;
import br.com.transportadora.repository.FilialRepository;
import br.com.transportadora.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by João on 23/08/2016.
 */

@Service
@Transactional
public class FilialServiceImpl extends CrudServiceImpl<Filial, Long> implements FilialService {

    @Autowired
    private FilialRepository filialRepository;

    @Override
    protected CrudRepository<Filial, Long> getRepository() {
        return this.filialRepository;
    }
}
