package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SignSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SignSubjectID;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student Student;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TermID", nullable = false)
    private Term Term;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SubjectMajorID", nullable = false)
    private SubjectMajor SubjectMajor;
}
