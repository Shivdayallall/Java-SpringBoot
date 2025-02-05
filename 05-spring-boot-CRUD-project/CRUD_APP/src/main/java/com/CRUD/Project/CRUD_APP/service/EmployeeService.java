package com.CRUD.Project.CRUD_APP.service;


import com.CRUD.Project.CRUD_APP.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    // find single employee
    Employee findById(int id);

    // save employee
    Employee save(Employee employee);

    // delete employee
    void delete(int id);
}
