package com.pamit.springbootmvc.controllers;

import com.pamit.springbootdemo.dao.EmployeeSpringDataJPA;
import com.pamit.springbootdemo.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> fakeEmployees;
    private EmployeeSpringDataJPA employeeSpringDataJPA;

    @Autowired
    public EmployeeController(EmployeeSpringDataJPA employeeSpringDataJPA) {
        this.employeeSpringDataJPA = employeeSpringDataJPA;
    }

    @PostConstruct
    private void loadData() {
        Employee emp1 = new Employee("Payam", "M", "a@a.a");
        Employee emp2 = new Employee("John", "Doe", "a@a.a");
        Employee emp3 = new Employee("Jack", "Smith", "a@a.a");

        fakeEmployees = new ArrayList<>();
        fakeEmployees.add(emp1);
        fakeEmployees.add(emp2);
        fakeEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
//        model.addAttribute("employees", fakeEmployees);
        List<Employee> employees = employeeSpringDataJPA.findAll();
        model.addAttribute("employees", employees);

        return "employees/list";
    }

    @GetMapping("/new")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/form";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
                                    Model model) {

        Optional<Employee> employee = employeeSpringDataJPA.findById(id);
        if (employee.isEmpty()) {
            // Handle error
            return "employees/list";
        }

        model.addAttribute("employee", employee.get());

        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeSpringDataJPA.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeSpringDataJPA.deleteById(id);

        return "redirect:/employees/list";
    }
}
