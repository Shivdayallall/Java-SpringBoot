package com.example.hibernateJPa.jpa.dao;

import com.example.hibernateJPa.jpa.entity.Student;

// whichever class choose to implement this interface(blueprint) it must also implement these methods.
public interface StudentDAO {
    void save(Student student);
}
