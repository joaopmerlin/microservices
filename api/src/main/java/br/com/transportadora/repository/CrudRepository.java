package br.com.transportadora.repository;

import br.com.transportadora.model.CrudModel;
import br.com.transportadora.model.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by João on 30/08/2016.
 */

@NoRepositoryBean
public interface CrudRepository<T extends CrudModel, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    List<T> findByEmpresa(Empresa empresa);

    List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAll(Iterable<ID> var1);

    <S extends T> List<S> save(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

}
