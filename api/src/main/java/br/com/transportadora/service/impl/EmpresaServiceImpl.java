package br.com.transportadora.service.impl;

import br.com.transportadora.model.Empresa;
import br.com.transportadora.repository.CrudRepository;
import br.com.transportadora.repository.EmpresaRepository;
import br.com.transportadora.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by João on 23/08/2016.
 */

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    @Override
    public Empresa find(Long id) {
        return this.empresaRepository.findOne(id);
    }
}
