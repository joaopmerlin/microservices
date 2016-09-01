package br.com.transportadora.controller;

import br.com.transportadora.model.Filial;
import br.com.transportadora.service.CrudService;
import br.com.transportadora.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by João on 23/08/2016.
 */

@RestController
@RequestMapping("filial")
public class FilialController extends CrudController<Filial, Long> {

    @Autowired
    private FilialService filialService;

    @Override
    protected CrudService<Filial, Long> getService() {
        return this.filialService;
    }
}
