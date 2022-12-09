package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Major;
import com.example.TrainingManagement.Models.Subject;
import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
    public default Major findBymajorCode(String majorCode){
        ArrayList<Major> list = (ArrayList<Major>) this.findAll();
        ArrayList<Major> listRespon = new ArrayList<>();
        list.forEach(major -> {
            if(major.getMajorCode().equals(majorCode)){
                listRespon.add(major);
            }
        });
        return  listRespon.get(0);
    }

}