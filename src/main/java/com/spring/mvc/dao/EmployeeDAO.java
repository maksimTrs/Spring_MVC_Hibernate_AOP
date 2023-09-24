package com.spring.mvc.dao;

import com.spring.mvc.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
