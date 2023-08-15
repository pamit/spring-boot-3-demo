package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student find(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> query(String firstName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student WHERE id > 5 OR firstName=:firstNameParam",  // Student is the entity name, NOT table name
                Student.class);

        typedQuery.setParameter("firstNameParam", firstName);

        return typedQuery.getResultList();
    }
}
