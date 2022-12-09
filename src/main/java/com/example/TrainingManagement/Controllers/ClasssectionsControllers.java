package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.DTO.DTOSubjectAndMajorResponse;
import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(path = "/Classsection", produces = "application/json")
public class ClasssectionsControllers {
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
    @Autowired
    private ClasssectionRepository classsectionRepository;
    @GetMapping("/AllClasssections/{id}")
    public ResponseEntity<?> GetAllSubjectSignedByTermNow(@PathVariable String id){
        SubjectMajor subjectMajor = subjectMajorRepository.findByid(Long.parseLong(id));
        Classsection classsection = classsectionRepository.findBySubjectMajor(subjectMajor);
        return new ResponseEntity<>(classsection, HttpStatus.OK);
    }

}
