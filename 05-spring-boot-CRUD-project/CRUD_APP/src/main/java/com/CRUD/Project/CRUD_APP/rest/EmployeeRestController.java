package com.CRUD.Project.CRUD_APP.rest;

import com.CRUD.Project.CRUD_APP.entity.Employee;
import com.CRUD.Project.CRUD_APP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // mapping for finding all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    // mapping for finding a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found" + employeeId) ;
        } else {
            return employee;
        }

    }

    // mapping to save employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // set id to 0 just incase the user update the id for an already saved ID
        employee.setId(0);

        Employee newEmployee = employeeService.save(employee);

        return newEmployee;
    }

    // mapping for updating employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee editEmployee = employeeService.save(employee);

        return editEmployee;
    }
















}
