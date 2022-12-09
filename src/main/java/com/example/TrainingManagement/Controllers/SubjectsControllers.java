package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.lang.Long;

@RestController
@RequestMapping(path = "/Subject", produces = "application/json")

public class SubjectsControllers {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMajorRepository subjectMajorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;

    public SubjectsControllers(SubjectRepository subjectRepository, SubjectMajorRepository subjectMajorRepository, StudentRepository studentRepository, MajorRepository majorRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectMajorRepository = subjectMajorRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
    }



    @GetMapping("/SubjectByTermNow")
    public Student GetAllSubjectByTermNow(){
        Student student = studentRepository.findAll().get(0);
//        String majorCode = student.getStudentCode().substring(5,7);
//        Major major = majorRepository.findBymajorCode(majorCode);
//        int year =5;
//        SubjectMajor subjectMajor= subjectMajorRepository.findByStartTermAndMajor(year, major);
        return student;
    }

}