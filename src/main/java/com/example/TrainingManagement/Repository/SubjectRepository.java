package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Subject;

import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public default Subject BinarySubject(String SubjectCode){
        ArrayList<Subject> list = (ArrayList<Subject>) this.findAll();
        ArrayList<Subject> listmh = new ArrayList<>();
        list.forEach(Subject -> {
            if(Subject.getSubjectCode().equals(SubjectCode)){
                listmh.add(Subject);
            }
        });
        return  listmh.get(0);
    }

}