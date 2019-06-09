package com.maktab.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImpl<E extends Serializable> implements BaseDAO<E> {

    protected final SessionFactory factory;

    protected abstract String getEntity();

    public BaseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public E update(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();

        return e;
    }

    @Override
    public E read(Serializable id) {

        Session session = factory.openSession();

        session.beginTransaction();

        E e = (E) session.createQuery("from " + getEntity() + " as entity where entity.id=" + id).uniqueResult();
//        E e = (E) session.get(getEntity(), id);
        session.getTransaction().commit();

        session.close();
        return e;
    }

    @Override
    public E refresh(E e){
        Session session = factory.openSession();

        session.beginTransaction();

        session.refresh(e);

        session.getTransaction().commit();

        session.close();

        return e;
    }


    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete " + getEntity() + " as entity where entity.id=" + id).executeUpdate();

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void deleteObj(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.delete(e);

        session.getTransaction().commit();

        session.close();
    }
}
