package com.maktab.model.dao;

import com.maktab.core.dao.BaseDAO;
import com.maktab.model.Employee;

import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee> {
    double maxSalaryByCity(String city);
    Employee maxPaidEmployeeInCity(String city);
    List<Employee> empsWithPostalCode(String postalCode);
}
