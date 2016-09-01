package br.com.transportadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by João on 15/08/2016.
 */

@Controller
@RequestMapping("finalizar-cadastro")
public class FinalizarCadastroController extends AbstractController {

    @Override
    protected String getViewName() {
        return "finalizarCadastro";
    }

}
