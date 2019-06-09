package com.maktab.core.dao;

import java.io.Serializable;

public interface BaseDAO<E extends Serializable> {

    void create(E e);

    E update(E e);

    E read(Serializable id);

    E refresh(E e);

    void delete(Serializable id);

    void deleteObj(E e);

}
