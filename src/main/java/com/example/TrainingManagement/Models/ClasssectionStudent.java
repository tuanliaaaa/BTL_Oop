package com.example.TrainingManagement.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClasssectionStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClasssectionStudentID;
    @ManyToOne
    @JoinColumn(name = "ClasssectionID", nullable = false)
    private Classsection Classsection;
    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student Student;

}
