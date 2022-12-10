package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ClasssectionStudentRepository extends JpaRepository<ClasssectionStudent, Long> {
    @Override
    @SuppressWarnings("unchecked")
    default ClasssectionStudent save(ClasssectionStudent classsectionStudent)
    {

        if(this.findByAllStudentAndClassection(classsectionStudent.getStudent(),classsectionStudent.getClasssection()).isEmpty()){
            return saveAndFlush(classsectionStudent);
        }
        return classsectionStudent;
    }
    public default List<ClasssectionStudent> findByStudent(Student student){
        ArrayList<ClasssectionStudent> list = (ArrayList<ClasssectionStudent>) this.findAll();
        ArrayList<ClasssectionStudent> listRespon = new ArrayList<>();
        list.forEach(classsectionStudent -> {
            if(classsectionStudent.getStudent().equals(student)){
                listRespon.add(classsectionStudent);
            }
        });
        return  listRespon;
    }
    public default ClasssectionStudent findByStudentAndClassection(Student student , Classsection classsection){
        ArrayList<ClasssectionStudent> list = (ArrayList<ClasssectionStudent>) this.findAll();
        ArrayList<ClasssectionStudent> listRespon = new ArrayList<>();
        list.forEach(classsectionStudent -> {
            if(classsectionStudent.getStudent().equals(student)&&classsectionStudent.getClasssection().equals(classsection)){
                listRespon.add(classsectionStudent);
            }
        });
        return  listRespon.get(0);
    }
    public  default List<ClasssectionStudent>findByAllStudentAndClassection(Student student , Classsection classsection){
        ArrayList<ClasssectionStudent> list = (ArrayList<ClasssectionStudent>) this.findAll();
        ArrayList<ClasssectionStudent> listRespon = new ArrayList<>();
        list.forEach(classsectionStudent -> {
        if(classsectionStudent.getStudent().equals(student)&&classsectionStudent.getClasssection().equals(classsection)){
            listRespon.add(classsectionStudent);
        }
    });
        return  listRespon;
}
}