package com.pamit.springbootdemo.services;

import com.pamit.springbootdemo.dao.StudentSpringDataJPA;
import com.pamit.springbootdemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

//    private StudentDAO repository;
//    @Autowired
//    public StudentService(StudentDAO repository) {
//        this.repository = repository;
//    }

    StudentSpringDataJPA repository;
    @Autowired
    public StudentService(StudentSpringDataJPA repository) {
        this.repository = repository;
    }
    
    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return repository.findById(id);
    }

    @Override
//    @Transactional // Not required for Spring Data JPA
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findByEmail(String email) {
        return repository.findByEmailLikeCaseInsensitive(email);
    }
}
