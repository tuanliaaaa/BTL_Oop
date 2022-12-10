package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.SignSubject;
import com.example.TrainingManagement.Models.Student;
import com.example.TrainingManagement.Models.SubjectMajor;
import com.example.TrainingManagement.Models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public interface SignSubjectRepository extends JpaRepository<SignSubject, Long> {
    @Override
    @SuppressWarnings("unchecked")
    default SignSubject save(SignSubject signSubject)
    {

        if(this.findByAll(signSubject.getStudent(),signSubject.getTerm(),signSubject.getSubjectMajor()).isEmpty()){
            return saveAndFlush(signSubject);
        }
        return signSubject;
    }
    public default List<SignSubject> FindByStudentAndTerm(Student student, Term term){
        ArrayList<SignSubject> list = (ArrayList<SignSubject>) this.findAll();
        ArrayList<SignSubject> signSubjects = new ArrayList<>();
        list.forEach(signsubject -> {
            if(signsubject.getTerm().equals(term)&& signsubject.getStudent().equals(student)){
                signSubjects.add(signsubject);
            }
        });
        return  signSubjects;
    }

    public default List<SignSubject> findByStudent(Student student){
        ArrayList<SignSubject> list = (ArrayList<SignSubject>) this.findAll();
        ArrayList<SignSubject> signSubjects = new ArrayList<>();
        list.forEach(signsubject -> {
            if( signsubject.getStudent().equals(student)){
                signSubjects.add(signsubject );
            }
        });
        return  signSubjects;
    }
    public default List<SignSubject> findByAll(Student student, Term term, SubjectMajor subjectMajor){
        ArrayList<SignSubject> list = (ArrayList<SignSubject>) this.findAll();
        ArrayList<SignSubject> signSubjects = new ArrayList<>();
        list.forEach(signsubject -> {
            if(signsubject.getTerm().equals(term)&& signsubject.getStudent().equals(student) && signsubject.getSubjectMajor().equals(subjectMajor)){
                signSubjects.add(signsubject );
            }
        });
        return  signSubjects;
    }

}
