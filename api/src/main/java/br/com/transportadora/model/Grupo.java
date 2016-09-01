package br.com.transportadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class Grupo implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa")
    @NotNull
    private Empresa empresa;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private Boolean ativo = true;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GrupoPrivilegio> privilegios;

    public Grupo(Empresa empresa, String nome) {
        this.empresa = empresa;
        this.nome = nome;
    }

}
