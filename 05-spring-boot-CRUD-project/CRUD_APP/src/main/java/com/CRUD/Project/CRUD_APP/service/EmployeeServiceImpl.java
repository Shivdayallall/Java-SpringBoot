package com.CRUD.Project.CRUD_APP.service;

import com.CRUD.Project.CRUD_APP.dao.EmployeeRespository;
import com.CRUD.Project.CRUD_APP.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRespository employeeRespository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee findById(int id) {
        // get id
        Optional<Employee> result = employeeRespository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            // couldn't find employee with that id
            throw new RuntimeException("Employee Not Found with id: " + result);
        }

        return employee;

    }

    @Override
    public Employee save(Employee employee) {
        return employeeRespository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRespository.deleteById(id);
    }


}
