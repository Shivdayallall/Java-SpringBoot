package com.CRUD.Project.CRUD_APP.dao;

import com.CRUD.Project.CRUD_APP.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
    // THATS IT. NO NEED TO WRITE ANY CODE. THE CRUD METHODS IS IMPLEMENTED FOR FREE
}
