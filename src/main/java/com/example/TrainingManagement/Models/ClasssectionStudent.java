package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClasssectionStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClasssectionStudentID;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ClasssectionID", nullable = false)
    private Classsection Classsection;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student Student;

}
