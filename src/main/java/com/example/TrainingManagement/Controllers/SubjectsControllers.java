package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.DTO.DTOSubject;
import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired

    private TermRepository termRepository;
    @Autowired
    private SignSubjectRepository signSubjectRepository;

    public SubjectsControllers(SubjectRepository subjectRepository, SubjectMajorRepository subjectMajorRepository, StudentRepository studentRepository, MajorRepository majorRepository, TermRepository termRepository, SignSubjectRepository signSubjectRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectMajorRepository = subjectMajorRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.termRepository = termRepository;
        this.signSubjectRepository = signSubjectRepository;
    }

    @GetMapping("/SubjectByTermNow")
    public ResponseEntity<?>  GetAllSubjectByTermNow(){
        Student student = studentRepository.findAll().get(0);
        String majorCode = student.getStudentCode().substring(5,7);
        Major major = majorRepository.findBymajorCode(majorCode);
        int year =5;
        List<SubjectMajor> subjectMajor= subjectMajorRepository.findByStartTermAndMajor(year, major);
        List<Subject> subjects = new ArrayList<>();
        for(SubjectMajor x : subjectMajor){
            subjects.add(x.getSubject());
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/AllSubjectSignedByTermNow")
    public ResponseEntity<?>  GetAllSubjectSignedByTermNow(){
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNow();
        List<SignSubject> signSubject = signSubjectRepository.findAll();
        List<SubjectMajor> subjectMajors =new ArrayList<>();
        for(SignSubject x : signSubject){
            subjectMajors.add(x.getSubjectMajor());
        }

        List<Subject> subjects = new ArrayList<>();
        for(SubjectMajor x : subjectMajors){
            subjects.add(x.getSubject());
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/AllSubjectSignedByTermNear")
    public ResponseEntity<?> GetAllSubjectSignedByTermNear(){
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNear();
        List<SignSubject> signSubject = signSubjectRepository.findAll();
        List<SubjectMajor> subjectMajors =new ArrayList<>();
        for(SignSubject x : signSubject){
            subjectMajors.add(x.getSubjectMajor());
        }

        List<Subject> subjects = new ArrayList<>();
        for(SubjectMajor x : subjectMajors){
            subjects.add(x.getSubject());
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/SubjectBySubjectCode/{SubjectCode}")
    public ResponseEntity<?>  GetAllSubjectBySubjectCode(@PathVariable String SubjectCode){
       Subject subject = subjectRepository.BinarySubject(SubjectCode);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

}