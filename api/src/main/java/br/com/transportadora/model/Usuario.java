package br.com.transportadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class Usuario implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    @Email
    private String email;

    @Column
    @NotNull
    private String senha;

    @Column
    @NotNull
    private LocalDateTime cadastro;

    @Column
    @NotNull
    private Boolean ativo = true;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioGrupo> grupos;

    public void addGrupo(UsuarioGrupo usuarioGrupo) {
        if (grupos == null) {
            grupos = new ArrayList<>();
        }
        grupos.add(usuarioGrupo);
    }

}
