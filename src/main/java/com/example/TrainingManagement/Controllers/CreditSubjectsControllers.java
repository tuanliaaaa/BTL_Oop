package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.DTO.DTOSubjectAndMajorResponse;
import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(path = "/SignCredit", produces = "application/json")
public class CreditSubjectsControllers {
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
    @GetMapping("/AllSubjectSignedByTermNow")
    public ResponseEntity<?> GetAllSubjectSignedByTermNow(){
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNowByCredit();
        List<SignSubject> signSubject = signSubjectRepository.findAll();
        List<SubjectMajor> subjectMajors =new ArrayList<>();
        for(SignSubject x : signSubject){
            subjectMajors.add(x.getSubjectMajor());
        }

        List<DTOSubjectAndMajorResponse> subjects = new ArrayList<>();
        for(SubjectMajor x : subjectMajors){
            DTOSubjectAndMajorResponse y=new DTOSubjectAndMajorResponse(x.getSubject().getSubjectID(),x.getSubject().getSubjectCode(),x.getSubject().getSubjectName(),x.getSubjectMajorID());
            subjects.add(y);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/AllSubjectSignedByTermNear")
    public ResponseEntity<?> GetAllSubjectSignedByTermNear(){
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNearCredit();
        List<SignSubject> signSubject = signSubjectRepository.findAll();
        List<SubjectMajor> subjectMajors =new ArrayList<>();
        for(SignSubject x : signSubject){
            subjectMajors.add(x.getSubjectMajor());
        }

        List<DTOSubjectAndMajorResponse> subjects = new ArrayList<>();
        for(SubjectMajor x : subjectMajors){
            DTOSubjectAndMajorResponse y=new DTOSubjectAndMajorResponse(x.getSubject().getSubjectID(),x.getSubject().getSubjectCode(),x.getSubject().getSubjectName(),x.getSubjectMajorID());
            subjects.add(y);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}
