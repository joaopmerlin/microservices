package br.com.transportadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class Filial implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa")
    @NotNull
    private Empresa empresa = new Empresa();

    @Column
    @NotNull
    private String razao;

    @Column
    @NotNull
    private String fantasia;

    @Column
    @NotNull
    private Boolean ativo = true;

    public Filial(Empresa empresa, String razao, String fantasia) {
        this.empresa = empresa;
        this.razao = razao;
        this.fantasia = fantasia;
    }

}
