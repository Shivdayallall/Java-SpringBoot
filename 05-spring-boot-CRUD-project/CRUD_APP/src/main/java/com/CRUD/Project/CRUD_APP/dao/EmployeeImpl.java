package com.CRUD.Project.CRUD_APP.dao;

import com.CRUD.Project.CRUD_APP.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeImpl implements EmployeeDAO {


    //define the fields for entitymanage
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute the query and get the results
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }



}
