package br.com.transportadora.service.impl;

import br.com.transportadora.model.Privilegio;
import br.com.transportadora.repository.PrivilegioRepository;
import br.com.transportadora.service.PrivilegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by João on 29/08/2016.
 */

@Service
@Transactional
public class PrivilegioServiceImpl implements PrivilegioService {

    @Autowired
    private PrivilegioRepository privilegioRepository;

    @Override
    public List<Privilegio> findAll() {
        return this.privilegioRepository.findAll();
    }
}
