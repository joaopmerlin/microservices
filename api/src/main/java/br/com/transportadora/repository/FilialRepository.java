package br.com.transportadora.repository;

import br.com.transportadora.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by João on 23/08/2016.
 */

@Repository
public interface FilialRepository extends CrudRepository<Filial, Long> {
}
