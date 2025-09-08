package com.java.employeeproject.Service;

import com.java.employeeproject.Model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);



}
