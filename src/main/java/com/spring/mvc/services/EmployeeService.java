package com.spring.mvc.services;

import com.spring.mvc.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
