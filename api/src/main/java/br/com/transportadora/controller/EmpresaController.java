package br.com.transportadora.controller;

import br.com.transportadora.model.Empresa;
import br.com.transportadora.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by João on 23/08/2016.
 */

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Empresa get(@PathVariable("id") Long id) {
        return this.empresaService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Empresa save(@RequestBody @Valid Empresa empresa) {
        return this.empresaService.save(empresa);
    }

}
