package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.SignSubject;
import com.example.TrainingManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SignSubjectRepository extends JpaRepository<SignSubject, Long> {
}
