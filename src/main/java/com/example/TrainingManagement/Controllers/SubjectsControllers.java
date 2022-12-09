package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.Models.Subject;
import com.example.TrainingManagement.Models.SubjectMajor;
import com.example.TrainingManagement.Models.Term;
import com.example.TrainingManagement.Repository.SubjectRepository;
import com.example.TrainingManagement.Repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/Subject", produces = "application/json")

public class SubjectsControllers {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectsControllers(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/SubjectByTermNow")
    public List<Subject> GetAllSubjectByTermNow(){
        return subjectRepository.findAll();
    }

}