package com.example.TrainingManagement.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SignSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SignSubjectID;
    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student Student;
    @ManyToOne
    @JoinColumn(name = "TermID", nullable = false)
    private Term Term;
    @ManyToOne
    @JoinColumn(name = "SubjectMajorID", nullable = false)
    private SubjectMajor SubjectMajor;
}
