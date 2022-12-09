package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.DTO.DTOSubject;
import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path = "/SignSubject", produces = "application/json")
public class SignSubjectsControllers {
    @Autowired
    private SignSubjectRepository signSubjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private TermRepository termRepository;
    @Autowired
    private SubjectMajorRepository subjectMajorRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @PostMapping("/SignSubjectBySubjectCode")
    public ResponseEntity<?> newEmployee(@RequestBody DTOSubject newSignSubject) {
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNowBySubject();
        String studentCode=student.getStudentCode().substring(5,7);
        Major major=majorRepository.findBymajorCode(studentCode);
        Subject subject =subjectRepository.BinarySubject(newSignSubject.getSubjectCode());
        SubjectMajor subjectMajor =subjectMajorRepository.findBySubjectAndMajor(subject,major);
        SignSubject signSubject = new SignSubject();
        signSubject.setStudent(student);
        signSubject.setTerm(term);
        signSubject.setSubjectMajor(subjectMajor);
        signSubjectRepository.save(signSubject);
        return new ResponseEntity<>(signSubject, HttpStatus.CREATED);
    }
    @DeleteMapping("/SignSubjectBySubjectCode/{subjectCode}")
    public ResponseEntity<?> DeleteEmployee(@PathVariable String subjectCode) {

        Student student = studentRepository.findAll().get(0);
        System.out.println("oke");
        Term term = termRepository.GetTermNowBySubject();
        String studentCode=student.getStudentCode().substring(5,7);
        Major major=majorRepository.findBymajorCode(studentCode);
        Subject subject =subjectRepository.BinarySubject(subjectCode);
        SubjectMajor subjectMajor =subjectMajorRepository.findBySubjectAndMajor(subject,major);
        SignSubject signSubject =signSubjectRepository.findByAll(student,term,subjectMajor).get(0);
        signSubjectRepository.delete(signSubject);
        return new ResponseEntity<>("da xoa thanh cong", HttpStatus.NO_CONTENT);
    }
}
