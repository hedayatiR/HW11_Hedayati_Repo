package com.maktab.model.dao;

import com.maktab.core.dao.BaseDaoImpl;
import com.maktab.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDAOImpl extends BaseDaoImpl<Employee> implements EmployeeDAO  {

    public EmployeeDAOImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntity() {
        return "Employee";
    }
}
