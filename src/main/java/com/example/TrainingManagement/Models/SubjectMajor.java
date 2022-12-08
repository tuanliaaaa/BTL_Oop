package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data

public class SubjectMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SubjectMajorID;
    private int NumberCredit;
    private int StartTerm;
    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject Subject;
    @ManyToOne
    @JoinColumn(name = "MajorID", nullable = false)
    private Major Major;
    @JsonBackReference
    @OneToMany(mappedBy = "SubjectMajor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SignSubject> SignSubject;
    @JsonBackReference
    @OneToMany(mappedBy = "SubjectMajor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classsection> Classsection;
}