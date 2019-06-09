package com.maktab.model.dao;

import com.maktab.core.dao.BaseDAO;
import com.maktab.model.Employee;

public interface EmployeeDAO extends BaseDAO<Employee> {
    double maxSalaryByCity(String city);
}
