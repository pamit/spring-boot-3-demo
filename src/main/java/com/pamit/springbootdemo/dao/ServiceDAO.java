package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Course;
import com.pamit.springbootdemo.entity.Instructor;
import com.pamit.springbootdemo.entity.InstructorDetail;
import com.pamit.springbootdemo.entity.Student;

import java.util.List;

public interface ServiceDAO {

    void save(Instructor instructor);

    void refresh(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);

    InstructorDetail findByInstructorDetailId(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findByIdJoinFetch(int id);

    void save(Course course);

    void refresh(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    List<Course> findCoursesByInstructorIdJoinFetch(int id);

    void save(Student student);
}
