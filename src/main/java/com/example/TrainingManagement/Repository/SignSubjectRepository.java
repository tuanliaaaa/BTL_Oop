package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.SignSubject;
import com.example.TrainingManagement.Models.Student;
import com.example.TrainingManagement.Models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public interface SignSubjectRepository extends JpaRepository<SignSubject, Long> {

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
}
