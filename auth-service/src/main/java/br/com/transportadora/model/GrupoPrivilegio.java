package br.com.transportadora.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Table(name = "grupoprivilegio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class GrupoPrivilegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "privilegio")
    private Privilegio privilegio;

}
