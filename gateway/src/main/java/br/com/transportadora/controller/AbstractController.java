package br.com.transportadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by João on 22/08/2016.
 */
public abstract class AbstractController {

    protected abstract String getViewName();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView search(ModelAndView modelAndView) {
        modelAndView.setViewName(getViewName());
        postSearch(modelAndView);
        return modelAndView;
    }

    protected void postSearch(ModelAndView modelAndView) {
    }

}
