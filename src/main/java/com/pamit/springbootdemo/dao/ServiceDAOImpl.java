package com.pamit.springbootdemo.dao;

import com.pamit.springbootdemo.entity.Course;
import com.pamit.springbootdemo.entity.Instructor;
import com.pamit.springbootdemo.entity.InstructorDetail;
import com.pamit.springbootdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

    EntityManager entityManager;

    @Autowired
    public ServiceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void refresh(Instructor instructor) {
        entityManager.refresh(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = findById(id);

        if (instructor != null) {
            instructor.getCourses()
                    .stream()
                    .forEach(course -> course.setInstructor(null));

            entityManager.remove(instructor);
        }
    }

    @Override
    public InstructorDetail findByInstructorDetailId(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :id",
                Course.class);

        query.setParameter("id", id);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findByIdJoinFetch(int id) {
        // JOIN FETCH returns both Instructor and its Courses
        TypedQuery<Instructor> query = entityManager.createQuery(
                  "SELECT i FROM Instructor i " +
                     "JOIN FETCH i.courses " +
                     "JOIN FETCH i.instructorDetail " +
                     "WHERE i.id = :id",
                Instructor.class);

        query.setParameter("id", id);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void refresh(Course course) {
        entityManager.refresh(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.reviews "
                        + "where c.id = :id",
                Course.class);

        query.setParameter("id", id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public List<Course> findCoursesByInstructorIdJoinFetch(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.reviews " +
                        "where instructor.id = :id",
                Course.class);

        query.setParameter("id", id);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }
}
