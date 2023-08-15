package com.pamit.springbootdemo.rest;

import com.pamit.io.SimpleIO;
import com.pamit.springbootdemo.dao.CourseRepository;
import com.pamit.springbootdemo.entity.Course;
import com.pamit.springbootdemo.models.CoursePractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("courses")
public class CoursesController {

    @Autowired
    CourseRepository courseRepository;

//    @Autowired
    SimpleIO simpleIO;

//    @Autowired
//    @Qualifier("easyCoursePractice")
    CoursePractice easyCoursePractice;

    CoursePractice hardCoursePractice;

    @Autowired
    public CoursesController(@Qualifier("defaultCoursePractice") CoursePractice hardCoursePractice) {
        this.hardCoursePractice = hardCoursePractice;
    }

    @Autowired
    public void setEasyCoursePractice(@Qualifier("easyCoursePractice") CoursePractice easyCoursePractice) {
        this.easyCoursePractice = easyCoursePractice;
    }

    @Autowired
    public void setSimpleIO(SimpleIO simpleIO) {
        this.simpleIO = simpleIO;
    }

    @Value("${courses.info}")
    private String coursesInfo;

    @GetMapping("/info")
    public String info() {
        return coursesInfo;
    }

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/daily-practice")
    public String getDailyPractice() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10);
        if (randomNum / 2 == 0)
            return easyCoursePractice.getDailyPractice() + " | " + simpleIO.stream();
        else
            return hardCoursePractice.getDailyPractice() + " | " + simpleIO.stream();
    }
}
