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
//			createSampleStudent(studentDAO);
		};
	}

	private void createSampleStudent(StudentDAO studentDAO) {
		Student student = new Student("Payam", "M", "a@a.a");
//		studentDAO.saveGeneric(student);
		studentDAO.save(student);
		System.out.println("New student created:");
		System.out.println(student.toString());

		// find
		System.out.println("Last student retrieved:");
		Student student1 = studentDAO.findById(2);
		System.out.println(student1.toString());

		// query
		System.out.println("Querying Students:");
		List<Student> students = studentDAO.findByFirstName("Payam");
		if (!students.isEmpty())
			students.forEach(System.out::println);

		// delete
		System.out.println("Deleteing student (1):");
		studentDAO.delete(1);

		// query
		System.out.println("Querying Students:");
		students = studentDAO.findByFirstName("Payam");
		if (!students.isEmpty())
			students.forEach(System.out::println);

		// update
		System.out.println("Updating student:");
		student.setLastName("MOU");
		studentDAO.update(student);
		System.out.println(student);
	}
}
