package com.pamit.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "403";
    }
}
