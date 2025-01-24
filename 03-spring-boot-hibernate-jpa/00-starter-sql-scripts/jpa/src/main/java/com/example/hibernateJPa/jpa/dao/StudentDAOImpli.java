package com.example.hibernateJPa.jpa.dao;

import com.example.hibernateJPa.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpli implements StudentDAO {

    // define fields for entity manager
    private EntityManager entityManager;


    // inject the entity manager using constructor injection
    @Autowired
    public StudentDAOImpli(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // implement the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }






}
