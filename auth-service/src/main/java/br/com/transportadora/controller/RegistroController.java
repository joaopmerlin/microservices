package br.com.transportadora.controller;

import br.com.transportadora.model.Usuario;
import br.com.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by João on 13/08/2016.
 */

@RefreshScope
@Controller
@RequestMapping("registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("registro");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView novo(
            ModelAndView modelAndView,
            @RequestParam String email,
            @RequestParam String nome,
            @RequestParam String senha1,
            @RequestParam String senha2) {

        if (senha1.equals(senha2)) {
            if (this.usuarioService.findByEmail(email).isPresent()) {
                modelAndView.addObject("email", true);
            } else {
                Usuario usuario = this.usuarioService.save(new Usuario(nome, email, senha1));
                if (usuario != null) {
                    modelAndView.addObject("success", true);
                } else {
                    modelAndView.addObject("error", true);
                }
            }
        } else {
            modelAndView.addObject("senha", true);
        }

        modelAndView.setViewName("registro");
        return modelAndView;
    }

}
