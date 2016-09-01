package br.com.transportadora.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Table(name = "grupoprivilegio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class GrupoPrivilegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grupo")
    @NotNull
    @JsonIgnore
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "privilegio")
    @NotNull
    private Privilegio privilegio;

    public GrupoPrivilegio(Grupo grupo, Privilegio privilegio) {
        this.grupo = grupo;
        this.privilegio = privilegio;
    }

}
