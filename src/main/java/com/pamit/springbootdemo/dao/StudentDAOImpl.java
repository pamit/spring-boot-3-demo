package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Student;
import com.pamit.springbootdemo.entity.User;
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
    public Student save(Student student) {
//        entityManager.persist(student);
        return entityManager.merge(student);
    }

    @Override
    public <T extends User> void saveGeneric(T t) {
        entityManager.persist(t);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student ORDER BY id",  // Student is the entity name, NOT table name
                Student.class);

        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student WHERE id > 2 OR firstName=:firstNameParam ORDER BY id",  // Student is the entity name, NOT table name
                Student.class);

        typedQuery.setParameter("firstNameParam", firstName);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

        // int rows = entityManager.createQuery("UPDATE Student set lastName='" + lastName + "'").executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null)
            entityManager.remove(student);

        // int rows = entityManager.createQuery("DELETE FROM Student WHERE lastName='" + lastName + "'").executeUpdate();
    }
}
