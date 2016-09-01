package br.com.transportadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by João on 29/08/2016.
 */

@RestController
@RequestMapping("cnpj")
public class CnpjController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "{cnpj}", method = RequestMethod.GET)
    public Object buscaCnpj(@PathVariable String cnpj) {
        return this.restTemplate.getForEntity("http://receitaws.com.br/v1/cnpj/" + cnpj, Object.class);
    }

}
