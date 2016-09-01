package br.com.transportadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by João on 15/08/2016.
 */

@Controller
@RequestMapping
public class HomeController extends AbstractController {

    @Override
    protected String getViewName() {
        return "home";
    }

}
