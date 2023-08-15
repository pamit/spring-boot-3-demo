package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom APIs
    List<Course> findByTitle(String title);
    List<Course> findByTitleAndAuthor(String title, String author);
    List<Course> findByTitleOrAuthor(String title, String author);
}
