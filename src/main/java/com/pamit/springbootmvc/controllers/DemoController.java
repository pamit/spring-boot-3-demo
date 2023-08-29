package com.pamit.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class DemoController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("theDate", new Date());

        return "helloworld";
    }
}
