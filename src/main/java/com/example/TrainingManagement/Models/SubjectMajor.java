package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject Subject;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "MajorID", nullable = false)
    private Major Major;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "SubjectMajor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SignSubject> SignSubject;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "SubjectMajor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classsection> Classsection;
}