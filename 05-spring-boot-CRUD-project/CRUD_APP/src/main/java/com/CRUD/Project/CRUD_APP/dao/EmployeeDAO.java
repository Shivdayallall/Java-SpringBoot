package com.CRUD.Project.CRUD_APP.dao;

import com.CRUD.Project.CRUD_APP.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
