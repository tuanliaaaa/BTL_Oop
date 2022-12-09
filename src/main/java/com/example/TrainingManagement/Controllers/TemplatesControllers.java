package com.example.TrainingManagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TemplatesControllers {
    @RequestMapping("/login")
    public String logins() {
        return "login";
    }
    @RequestMapping("/schedule")
    public String shedules() {
        return "schedule";
    }
    @RequestMapping("/creditRegistration")
    public String creditRegistrations() {
        return "creditRegistration";
    }
    @RequestMapping("/subjectRegistration")
    public String subjectRegistrations() {
        return "subjectRegistration";
    }
}
