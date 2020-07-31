package com.pnguyen.core.data.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<ID extends Serializable, T> {
    List<T> findAll();
    T update(T entity);
    void save(T entity);
    T findById(ID id);
    Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection);
    Integer delete(List<ID> ids);

}
