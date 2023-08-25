package com.pamit.springbootdemo.cmdrunners;

import com.pamit.springbootdemo.dao.ServiceDAO;
import com.pamit.springbootdemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandRunnerForInstructors implements CommandLineRunner {

    ServiceDAO serviceDAO;

    @Autowired
    public CommandRunnerForInstructors(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[CommandRunnerForInstructors] Running...");

        Instructor instructor = new Instructor("Payam", "M", "a@a.a");

        InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "walking");
        instructor.setInstructorDetail(instructorDetail);

        instructor.addCourse(new Course("Math"));
        instructor.addCourse(new Course("Computer Science"));

        serviceDAO.save(instructor);
        System.out.println("[CommandRunnerForInstructors] Instructor saved: " + instructor.toString());
        System.out.println("[CommandRunnerForInstructors] Instructor (1) > courses fetched: " +
                instructor.getCourses()
                        .stream()
                        .map(course -> course.getTitle()).collect(Collectors.toList()));

        InstructorDetail instructorDetail1 = serviceDAO.findByInstructorDetailId(1);
        if (instructorDetail1 != null) {
            System.out.println("[CommandRunnerForInstructors] InstructorDetail (1) fetched: " +
                    instructorDetail1);
            System.out.println("[CommandRunnerForInstructors] InstructorDetail (1) > Instructor: " +
                    instructorDetail1.getInstructor());
        }

        Instructor instructor1 = serviceDAO.findById(1);
        System.out.println("[CommandRunnerForInstructors] Instructor (1) fetched: " + instructor1);
//        List<Course> courses = serviceDAO.findCoursesByInstructorId(1);
//        instructor.setCourses(courses); // associate the objects
        System.out.println("[CommandRunnerForInstructors] Courses by instructor (1) fetched: " + instructor.getCourses());

        instructor1 = serviceDAO.findByIdJoinFetch(1);
        System.out.println("[CommandRunnerForInstructors] Instructor (1) fetched by JOIN FETCH: " + instructor1 +
                " - Courses: " + instructor.getCourses());

        List<Course> courses = serviceDAO.findCoursesByInstructorIdJoinFetch(1);
        System.out.println("[CommandRunnerForInstructors] Adding Reviews to Courses: " + courses);
        courses.stream().forEach(course -> {
            course.addReview(new Review("This is amazing!"));
            course.addReview(new Review("Surely 9/10!"));
        });
        System.out.println("[CommandRunnerForInstructors] Reviews: " +
                courses.stream().map(course -> course.getReviews()).collect(Collectors.toList()));

        Course course1 = new Course("Foo");
        course1.addReview(new Review("10 of 10"));
        course1.setInstructor(instructor1);
        serviceDAO.save(course1);
        System.out.println("[CommandRunnerForInstructors] Course saved: " + course1 +
                " | Reviews: " + course1.getReviews());

//        serviceDAO.delete(1);
//        System.out.println("[CommandRunnerForInstructors] Instructor (1) deleted");

        Student student = new Student("Payam", "M", "a@a.a");
        Course course2 = new Course("Software");
        student.addCourse(course2); serviceDAO.save(student);
//        course2.addStudent(student); serviceDAO.save(course2);
        System.out.println("[CommandRunnerForInstructors] New Student: " + student +
                " | Courses: " + student.getCourses());
        System.out.println("[CommandRunnerForInstructors] New Course: " + course2 +
                " | Courses: " + course2.getStudents());

    }
}
