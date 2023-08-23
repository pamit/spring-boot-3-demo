package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Employee;
import com.pamit.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "employees")
public interface EmployeeSpringDataJPA extends JpaRepository<Employee, Integer> {

    @Query("SELECT t FROM Student t WHERE t.firstName LIKE %?1%")
    List<Student> findByFirstName(String firstName);

    @Query("SELECT t FROM Employee t WHERE LOWER(t.email) LIKE LOWER(CONCAT('%', :email,'%'))")
    List<Student> findByEmail(@Param("email") String email);
}
