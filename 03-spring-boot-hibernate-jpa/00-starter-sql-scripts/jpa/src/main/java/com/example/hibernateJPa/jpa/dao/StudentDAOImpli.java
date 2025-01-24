package com.example.hibernateJPa.jpa.dao;

import com.example.hibernateJPa.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class); // use the ENTITY class to query tables.

        // return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }


}
