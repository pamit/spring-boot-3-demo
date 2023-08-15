package com.pamit.springbootdemo.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // For Spring component-scan
@Primary   // This implementation will be used when auto-wiring CoursePractice interface
@Lazy      // For lazy init, when needed for DI or explicit request
public class EasyCoursePractice implements CoursePractice {

    public EasyCoursePractice() {
        System.out.println("Initialising " + getClass().getSimpleName());
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("After init " + getClass().getSimpleName());
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("Before destroy " + getClass().getSimpleName());
    }

    @Override
    public String getDailyPractice() {
        return "Practice: " + getClass().getSimpleName();
    }
}
