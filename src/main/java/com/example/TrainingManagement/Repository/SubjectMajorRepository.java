package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Major;
import com.example.TrainingManagement.Models.Subject;
import com.example.TrainingManagement.Models.SubjectMajor;
import com.example.TrainingManagement.Models.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface SubjectMajorRepository extends JpaRepository<SubjectMajor, Long> {
    public default SubjectMajor findByStartTermAndMajor(int startTerm, Major major){
        ArrayList<SubjectMajor> list = (ArrayList<SubjectMajor>) this.findAll();
        ArrayList<SubjectMajor> listRespon = new ArrayList<>();
        list.forEach(subjectmajor -> {
            if(subjectmajor.getStartTerm()==startTerm && subjectmajor.getMajor()==major){
                listRespon.add(subjectmajor);
            }
        });
        return  listRespon.get(0);
    }
}