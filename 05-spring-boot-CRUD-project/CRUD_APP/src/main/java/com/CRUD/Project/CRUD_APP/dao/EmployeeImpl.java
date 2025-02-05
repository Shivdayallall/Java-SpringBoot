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

    @Override
    public Employee findById(int id) {
        // get employee id
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    // save the employee if the id == 0 else update the employee
    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee savedEmployee = entityManager.merge(employee);

        // return the employee
        return savedEmployee;
    }

    @Override
    public void delete(int id) {
        // find employee id
        Employee employee = entityManager.find(Employee.class, id);

        // remove the employee
        entityManager.remove(employee);

    }


}
