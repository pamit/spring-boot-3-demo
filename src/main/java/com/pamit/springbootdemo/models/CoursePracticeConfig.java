package com.pamit.springbootdemo.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoursePracticeConfig {

    @Bean("defaultCoursePractice")
    public CoursePractice hardCoursePractice() {
        return new HardCoursePractice();
    }
}
