package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Classsection;

import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface ClasssectionRepository extends JpaRepository<Classsection, Long> {
    public default Classsection findBySubjectMajor(SubjectMajor subjectMajor){
        ArrayList<Classsection> list = (ArrayList<Classsection>) this.findAll();
        ArrayList<Classsection> listRespon = new ArrayList<>();
        list.forEach(Classsection -> {
            if(Classsection.getSubjectMajor().equals(subjectMajor)){
                listRespon.add(Classsection);
            }
        });
        return  listRespon.get(0);
    }
}
