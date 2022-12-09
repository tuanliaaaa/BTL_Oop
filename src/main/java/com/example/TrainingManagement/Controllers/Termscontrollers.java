package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.Models.Term;
import com.example.TrainingManagement.Repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Term", produces = "application/json")

public class Termscontrollers {
    @Autowired
    private TermRepository termRepository;
    public Termscontrollers(TermRepository termRepository) {
        this.termRepository = termRepository;
    }
    @GetMapping("/TermNow")
    public Term GetAllTermNow(){
        return termRepository.GetTermNowBySubject();
    }

}
