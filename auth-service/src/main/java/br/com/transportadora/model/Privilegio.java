package br.com.transportadora.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by João on 05/08/2016.
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Privilegio implements GrantedAuthority, Serializable {

    @Id
    private Long id;

    @Column
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
