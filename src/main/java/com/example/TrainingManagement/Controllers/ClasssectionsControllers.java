package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.DTO.DTOClasssectionResponse;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private ScheduleRepository scheduleRepository;
    @Autowired

    private TermRepository termRepository;
    @Autowired
    private SignSubjectRepository signSubjectRepository;
    @Autowired
    private ClasssectionRepository classsectionRepository;

    public ClasssectionsControllers(SubjectRepository subjectRepository, SubjectMajorRepository subjectMajorRepository, StudentRepository studentRepository, MajorRepository majorRepository, ScheduleRepository scheduleRepository, TermRepository termRepository, SignSubjectRepository signSubjectRepository, ClasssectionRepository classsectionRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectMajorRepository = subjectMajorRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.scheduleRepository = scheduleRepository;
        this.termRepository = termRepository;
        this.signSubjectRepository = signSubjectRepository;
        this.classsectionRepository = classsectionRepository;
    }
    public  String danhsachngayhoc(Classsection classsection){
        List<Schedule> schedules = scheduleRepository.findByClasssrction(classsection);
        HashSet<String>  ngayhoc = new HashSet<String>();
        final String[] a = {""};
        schedules.forEach(schedule -> {
            ngayhoc.add(schedule.getStudytime());
        });
        ngayhoc.forEach(ngay -> {
            a[0] +=ngay+"(";
            List<Schedule> schedule2s= scheduleRepository.findByStudytime(ngay);
            schedule2s.forEach(schedule -> {
                a[0]+=schedule.getStudyweek().getStudyweekNumber();
                a[0]+="-";
            });
            a[0]=a[0].substring(0,a[0].length()-1);
            a[0]+="),";
        });
        return a[0];
    }
    @GetMapping("/AllClasssections/{id}")
    public ResponseEntity<?> GetAllSubjectSignedByTermNow(@PathVariable String id){
        SubjectMajor subjectMajor = subjectMajorRepository.findByid(Long.parseLong(id));
        List<Classsection> classsections = classsectionRepository.findBySubjectMajor(subjectMajor);
        List<DTOClasssectionResponse> classsectionResponses =new ArrayList<>();
        classsections.forEach(classsection -> {
            DTOClasssectionResponse classsectionResponse =new DTOClasssectionResponse(classsection.getClasssectionID(),classsection.getSubjectMajor().getSubject().getSubjectCode(),classsection.getSubjectMajor().getSubject().getSubjectName(),classsection.getQuantityReal(),classsection.getQuantity(),classsection.getTeacher().getTeacherName(),danhsachngayhoc(classsection));
            classsectionResponses.add(classsectionResponse);
        });
        return new ResponseEntity<>(classsectionResponses, HttpStatus.OK);
    }

}
