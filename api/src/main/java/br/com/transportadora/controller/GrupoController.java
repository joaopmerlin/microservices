package br.com.transportadora.controller;

import br.com.transportadora.model.Grupo;
import br.com.transportadora.service.CrudService;
import br.com.transportadora.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by João on 23/08/2016.
 */

@RestController
@RequestMapping("grupo")
public class GrupoController extends CrudController<Grupo, Long> {

    @Autowired
    private GrupoService grupoService;

    @Override
    protected CrudService<Grupo, Long> getService() {
        return this.grupoService;
    }
}
