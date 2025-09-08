package com.java.employeeproject.Service;

import com.java.employeeproject.Model.Employee;
import com.java.employeeproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> tempEmp = employeeRepository.findById(id);
        Employee theEmployee = null;

        if(tempEmp.isPresent())
            theEmployee = tempEmp.get();

        else
            throw new RuntimeException("Employee not found with ID : " + id);

        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        Optional<Employee> tempEmp = employeeRepository.findById(id);

        if (tempEmp.isPresent())
            employeeRepository.deleteById(id);
        else
            throw new RuntimeException("Employee Not Found with ID : " + id);
    }
}
