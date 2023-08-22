package com.pamit.springbootdemo.rest;

import com.pamit.springbootdemo.entity.Student;
import com.pamit.springbootdemo.exceptions.RecordNotFoundException;
import com.pamit.springbootdemo.services.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentsController {

    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    public void doSomethingAfterInit() {
        // e.g. load data, ...
    }

    @GetMapping
    public List<Student> list() {
        return studentService.findAll();
    }

    @GetMapping("/query")
    public List<Student> query(@RequestParam String email) {
        return studentService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable int id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isEmpty())
            throw new RecordNotFoundException("Student not found!");

        return student.get();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }
}
