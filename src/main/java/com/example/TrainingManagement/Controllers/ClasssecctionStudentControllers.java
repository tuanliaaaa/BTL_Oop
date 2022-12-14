package com.example.TrainingManagement.Controllers;

import ch.qos.logback.core.util.COWArrayList;
import com.example.TrainingManagement.DTO.DTOClasssectioinStudentResponse;
import com.example.TrainingManagement.DTO.DTOClasssection;
import com.example.TrainingManagement.DTO.DTOSubject;
import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import com.example.TrainingManagement.exception.ResponeAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(path = "/ClasssectionStudent", produces = "application/json")
public class ClasssecctionStudentControllers {
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
    @Autowired
    private ClasssectionStudentRepository classsectionStudentRepository;

    @GetMapping("/AllClasssectionStudent")
    public ResponseEntity<?> GetAllClasssectionStudent(){
        Student student = studentRepository.findAll().get(0);
        List<ClasssectionStudent> classsectionStudent = classsectionStudentRepository.findByStudent(student);
        List<DTOClasssectioinStudentResponse> classsectioinStudentResponses=new ArrayList<>();
        classsectionStudent.forEach(classsectionStudent1-> {

            DTOClasssectioinStudentResponse dtoClasssectioinStudentResponse=new DTOClasssectioinStudentResponse(classsectionStudent1.getClasssectionStudentID(),classsectionStudent1.getClasssection().getClasssectionID(),classsectionStudent1.getClasssection().getSubjectMajor().getSubject().getSubjectCode(),classsectionStudent1.getClasssection().getSubjectMajor().getSubject().getSubjectName());
            classsectioinStudentResponses.add(dtoClasssectioinStudentResponse);

        });
        return new ResponseEntity<>(classsectioinStudentResponses, HttpStatus.OK);
    }
    @DeleteMapping("/ClasssectionStudent/{id}")
    public ResponseEntity<?> DeleteClasssectionStudent(@PathVariable String id){
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNowByCredit();
        Classsection classsection =classsectionRepository.findByID(Long.parseLong(id));

        ClasssectionStudent classsectionStudent =classsectionStudentRepository.findByStudentAndClassection(student,classsection);
        classsectionStudentRepository.delete(classsectionStudent);
        classsection.setQuantityReal(classsection.getQuantityReal()-1);
        classsectionRepository.save(classsection);
        return new ResponseEntity<>("da xoa thanh cong", HttpStatus.NO_CONTENT);
    }
    @PostMapping("/ClasssectionStudents")
    public ResponseEntity<?> newStudent(@RequestBody DTOClasssection classsection) {
        Student student = studentRepository.findAll().get(0);
        Term term = termRepository.GetTermNowByCredit();
        Classsection classsection1 = classsectionRepository.findByID(classsection.getClasssectionID());
        //Li???t K?? l???ch h???c c???a t???t c??? c??c m??n ???? c?? neeus c?? m??n dki r???i th?? thay ?????i r???i m???i cho v??o
        List<ClasssectionStudent> classsectionStudents=classsectionStudentRepository.findByStudent(student);
        List<Classsection> classsections=new ArrayList<>();
        final ClasssectionStudent[] classsectionStudentPop = {new ClasssectionStudent()};
        classsectionStudents.forEach(classsectionStudent -> {
            if(classsectionStudent.getClasssection().getSubjectMajor().equals(classsection1.getSubjectMajor())){
                   classsectionStudentPop[0] = classsectionStudent;

            }
            else {
                classsections.add(classsectionStudent.getClasssection());
            }
            });
        List<Schedule> schedules=new ArrayList<>();
        classsections.forEach(classsection2 -> {
            List<Schedule> schedules2 =scheduleRepository.findByClasssrction(classsection2);
            schedules2.forEach(schedule ->{
                schedules.add(schedule);
            } );
        });
        List<String> LessonListNow=new ArrayList<>();
        schedules.forEach(schedule ->{
            String a=schedule.getStudytime();
            String b="";
            int index = a.indexOf("T");
            for(int i=0;i<schedule.getLessonNumber();i++){
                 b=a.substring(0,index+1)+String.valueOf(Integer.parseInt(String.valueOf(a.charAt(index+1)))+i)+"X"+schedule.getStudyweek().getStudyweekNumber();
                LessonListNow.add(b);
            }
        });
//        Li???t k?? l???ch h???c c???a m??n m???i

        List<Schedule> schedules1 =scheduleRepository.findByClasssrction(classsection1);
        List<String> LessonListResponse=new ArrayList<>();

        schedules1.forEach(schedule ->{
            String a=schedule.getStudytime();
            String b="";
            int index = a.indexOf("T");
            for(int i=0;i<schedule.getLessonNumber();i++){
                b=a.substring(0,index+1)+String.valueOf(Integer.parseInt(String.valueOf(a.charAt(index+1)))+i)+"X"+schedule.getStudyweek().getStudyweekNumber();
                LessonListResponse.add(b);
            }
        });
        for(String x:LessonListResponse)
        {
            if(LessonListNow.contains(x)){
                ResponeAPI responeAPI=new ResponeAPI();
                responeAPI.setError("Tr??ng L???ch H???c");
                return new ResponseEntity<>(responeAPI, HttpStatus.NOT_FOUND);
            }
        }
        if(classsection1.getQuantity()<=classsection1.getQuantityReal()){
             ResponeAPI responeAPI=new ResponeAPI();
             responeAPI.setError("L???p ???? ?????y");
            return new ResponseEntity<>(responeAPI, HttpStatus.NOT_FOUND);
        }
        ClasssectionStudent classsectionStudent= new ClasssectionStudent();
        classsectionStudent.setStudent(student);
        classsectionStudent.setClasssection(classsection1);
        classsection1.setQuantityReal(classsection1.getQuantityReal()+1);

        classsectionStudentRepository.save(classsectionStudent);
        classsectionStudentRepository.delete(classsectionStudentPop[0]);
        classsectionRepository.save(classsection1);
        return new ResponseEntity<>(classsectionStudents, HttpStatus.CREATED);
    }
}
