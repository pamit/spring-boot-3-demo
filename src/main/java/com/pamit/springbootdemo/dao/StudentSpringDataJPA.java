package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentSpringDataJPA extends JpaRepository<Student, Integer> {

    @Query("SELECT t FROM Student t WHERE t.firstName LIKE %?1%")
    List<Student> findByFirstNameLike(String firstName);

    @Query("SELECT t FROM Student t WHERE LOWER(t.email) LIKE LOWER(CONCAT('%', :email,'%'))")
    List<Student> findByEmailLikeCaseInsensitive(@Param("email") String email);
}
