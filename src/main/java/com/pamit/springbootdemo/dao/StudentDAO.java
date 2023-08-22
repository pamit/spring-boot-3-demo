package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Student;
import com.pamit.springbootdemo.entity.User;

import java.util.List;

public interface StudentDAO {
    Student save(Student student);

    <T extends User> void saveGeneric(T student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String firsName);

    void update(Student student);

    void delete(int id);
}
