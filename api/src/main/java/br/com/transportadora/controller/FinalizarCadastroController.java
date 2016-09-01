package br.com.transportadora.controller;

import br.com.transportadora.model.*;
import br.com.transportadora.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by João on 24/08/2016.
 */

@RestController
@RequestMapping("finalizar-cadastro")
public class FinalizarCadastroController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private FilialService filialService;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PrivilegioService privilegioService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity registro(@RequestBody @Valid Filial filial) {
        Empresa empresa = this.empresaService.save(new Empresa(filial.getRazao()));

        filial.setEmpresa(empresa);
        this.filialService.save(filial);

        Grupo grupo = this.grupoService.save(new Grupo(empresa, "Administrador"));
        List<GrupoPrivilegio> privilegios = this.privilegioService.findAll().stream().map(e -> new GrupoPrivilegio(grupo, e)).collect(Collectors.toList());
        grupo.setPrivilegios(privilegios);

        Usuario usuario = this.usuarioService.usuarioLogado();
        usuario.setEmpresa(empresa);
        usuario = this.usuarioService.save(usuario);
        usuario.setGrupos(Arrays.asList(new UsuarioGrupo(usuario, grupo)));

        return ResponseEntity.ok(usuario);
    }

}
