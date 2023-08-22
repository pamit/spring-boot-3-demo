package com.pamit.springbootdemo.services;

import com.pamit.springbootdemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAll();

    Optional<Student> findById(int id);

    Student save(Student student);

    List<Student> findByEmail(String email);
}
