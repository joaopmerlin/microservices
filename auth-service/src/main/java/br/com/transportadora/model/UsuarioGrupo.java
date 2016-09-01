package br.com.transportadora.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Table(name = "usuariogrupo")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_hibernate", sequenceName = "seq_hibernate")
public class UsuarioGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;
}
