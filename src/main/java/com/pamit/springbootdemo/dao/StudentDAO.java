package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student find(int id);

    List<Student> query(String firsName);
}
