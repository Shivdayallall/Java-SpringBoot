package com.example.hibernateJPa.jpa.dao;

import com.example.hibernateJPa.jpa.entity.Student;

import java.util.List;

// whichever class choose to implement this interface(blueprint) it must also implement these methods.
public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student student);

}
