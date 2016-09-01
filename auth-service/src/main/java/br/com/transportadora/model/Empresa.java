package br.com.transportadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by João on 31/08/2016.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa implements Serializable {

    @Id
    private Long id;

    @Column
    private String nome;
}
