package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Department;
import net.skhu.domain.Employee;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.EmployeeRepository;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired EmployeeRepository employeeRepository;

    @RequestMapping(value="employees",method=RequestMethod.GET)
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value="employee/{id}",method=RequestMethod.GET)
    public Employee employee(@PathVariable("id") int id) {
        return employeeRepository.findById(id).get();
    }
    
    @RequestMapping(value="departments",method=RequestMethod.GET)
    public List<Department> departments() {
        return departmentRepository.findAll();
    }
    @RequestMapping(value="department/{id}",method=RequestMethod.GET)
    public Department department(@PathVariable("id")int id) {
        return departmentRepository.findById(id).get();
    }
}

