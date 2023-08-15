package com.pamit.springbootdemo;

import com.pamit.springbootdemo.dao.StudentDAO;
import com.pamit.springbootdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = { "com.pamit.springbootdemo", "com.pamit.io" })
public class SpringbootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createSampleStudent(studentDAO);
		};
	}

	private void createSampleStudent(StudentDAO studentDAO) {
//		Student student = new Student("Payam", "M", "a@a.a");
//		studentDAO.save(student);
//		System.out.println("New student created:");
//		System.out.println(student.toString());

		// find
		System.out.println("Last student retrieved:");
		System.out.println(studentDAO.find(2).toString());

		// query
		System.out.println("Querying Students:");
		List<Student> students = studentDAO.query("Payam");
		if (!students.isEmpty())
			students.forEach(System.out::println);
	}
}
