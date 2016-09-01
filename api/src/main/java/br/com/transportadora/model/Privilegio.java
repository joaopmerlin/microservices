package br.com.transportadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by João on 23/08/2016.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilegio implements Serializable {

    @Id
    private Long id;

    @Column
    @NotNull
    private String role;

}
