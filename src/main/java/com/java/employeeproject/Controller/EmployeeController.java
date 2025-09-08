package com.java.employeeproject.Controller;

import com.java.employeeproject.Model.Employee;
import com.java.employeeproject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getAllEmps(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "listEmployees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee emp){
        employeeService.save(emp);
        return "redirect:/employees/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Employee tempEmp = employeeService.findById(id);
        model.addAttribute("emp", tempEmp);
        return "updateEmployee";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee emp){
        employeeService.save(emp);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
