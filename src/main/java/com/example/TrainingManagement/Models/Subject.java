package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SubjectID;
    private String SubjectCode;
    private String SubjectName;
    @JsonBackReference
    @OneToMany(mappedBy = "Subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SubjectMajor> SubjectMajor;
}
