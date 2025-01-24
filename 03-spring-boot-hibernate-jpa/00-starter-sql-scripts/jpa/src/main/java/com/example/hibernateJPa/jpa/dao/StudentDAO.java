package com.example.hibernateJPa.jpa.dao;

import com.example.hibernateJPa.jpa.entity.Student;

import java.util.List;

// whichever class choose to implement this interface(blueprint) it must also implement these methods.
public interface StudentDAO {
    // CREATE
    void save(Student student);

    // READ
    Student findById(Integer id);

    List<Student> findAll();

    // UPDATE
    void update(Student student);

    // DELETE
    void delete(Integer id);
}
