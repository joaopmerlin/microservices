package br.com.transportadora.controller;

import br.com.transportadora.model.CrudModel;
import br.com.transportadora.service.CrudService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Created by João on 22/08/2016.
 */
public abstract class CrudController<T extends CrudModel, ID extends Serializable> {

    protected abstract CrudService<T, ID> getService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public T get(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<T> get() {
        return getService().findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity save(@RequestBody @Valid T entidade) {
        try {
            preSave(entidade);
            getService().save(entidade);
            postSave(entidade);
            return ResponseEntity.ok(entidade);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") ID id) {
        try {
            getService().remove(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    protected T preSave(T entidade) {
        return entidade;
    }

    protected T postSave(T entidade) {
        return entidade;
    }

}
