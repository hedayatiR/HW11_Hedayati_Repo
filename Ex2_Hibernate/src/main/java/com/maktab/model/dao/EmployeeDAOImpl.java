package com.maktab.model.dao;

import com.maktab.core.dao.BaseDaoImpl;
import com.maktab.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDAOImpl extends BaseDaoImpl<Employee> implements EmployeeDAO {

    public EmployeeDAOImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntity() {
        return "Employee";
    }

    @Override
    public double maxSalaryByCity(String city) {
        Session session = factory.openSession();

        double maxSalary = (double) session.createQuery("select e.salary from Employee e inner join e.addresses a where " +
                "a.city=?1 order by e.salary DESC")
                .setParameter(1, city)
                .setMaxResults(1)
                .getSingleResult();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Max salary of " + city + " city is :");
        System.out.println(maxSalary);
        System.out.println();
        System.out.println();

        session.close();
        return maxSalary;
    }

}
