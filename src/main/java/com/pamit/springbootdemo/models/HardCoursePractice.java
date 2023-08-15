package com.pamit.springbootdemo.models;

public class HardCoursePractice implements CoursePractice {

    public HardCoursePractice() {
        System.out.println("Initialising " + getClass().getSimpleName());
    }

    @Override
    public String getDailyPractice() {
        return "Practice: " + getClass().getSimpleName();
    }
}
