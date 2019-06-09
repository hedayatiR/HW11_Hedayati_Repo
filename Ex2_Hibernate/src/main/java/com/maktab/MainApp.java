package com.maktab;

import com.maktab.model.Address;
import com.maktab.model.Employee;
import com.maktab.model.PhoneNumber;
import com.maktab.model.dao.EmployeeDAO;
import com.maktab.model.dao.EmployeeDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        EmployeeDAO employeeDAO = new EmployeeDAOImpl(factory);

        // make phoneNumbers
        PhoneNumber phoneNumber1 = new PhoneNumber("1", "5643");
        PhoneNumber phoneNumber2 = new PhoneNumber("2", "5643");
        PhoneNumber phoneNumber3 = new PhoneNumber("3", "5643");
        PhoneNumber phoneNumber4 = new PhoneNumber("4", "5643");
        PhoneNumber phoneNumber5 = new PhoneNumber("5", "5643");
        PhoneNumber phoneNumber6 = new PhoneNumber("6", "5643");
        PhoneNumber phoneNumber7 = new PhoneNumber("7", "5643");
        PhoneNumber phoneNumber8 = new PhoneNumber("3", "5643");
        PhoneNumber phoneNumber9 = new PhoneNumber("9", "5643");

        // make addresses
        Address address1 = new Address("123", "Zone2", "Tehran");
        Address address2 = new Address("123324", "Zone2","Mashhad");
        Address address3 = new Address("1231231", "Zone2","Tehran");
        Address address4 = new Address("123", "Zone2","Feri");
        Address address5 = new Address("12344", "Zone2","Tehran");
        Address address6 = new Address("1238675", "Zone2","Mashhad");

        // make Employees
        Employee employee1 = new Employee("Reza", 123L, 1000);
        Employee employee2 = new Employee("Ali", 13L, 4000);
        Employee employee3 = new Employee("Hasan", 3L, 5000);


        // assign phoneNumbers to address
        address1.addPhoneNumber(phoneNumber1);
        address1.addPhoneNumber(phoneNumber2);
        address2.addPhoneNumber(phoneNumber3);
        address3.addPhoneNumber(phoneNumber4);
        address4.addPhoneNumber(phoneNumber5);
        address5.addPhoneNumber(phoneNumber6);
        address5.addPhoneNumber(phoneNumber7);
        address6.addPhoneNumber(phoneNumber8);
        address6.addPhoneNumber(phoneNumber9);

        // assign addresses to employee
        employee1.addAddress(address1);
        employee1.addAddress(address2);
        employee2.addAddress(address3);
        employee2.addAddress(address4);
        employee3.addAddress(address5);
        employee3.addAddress(address6);

        //-----------------------------------------------------------

        // create employees
        employeeDAO.create(employee1);
        employeeDAO.create(employee2);
        employeeDAO.create(employee3);

        factory.close();
    }
}
