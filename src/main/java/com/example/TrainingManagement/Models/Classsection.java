package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Classsection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClasssectionID;
    private int quantity;
    private int quantityReal;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TeacherID", nullable = false)
    private Teacher Teacher;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TermID", nullable = false)
    private Term Term;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SubjectMajorID", nullable = false)
    private SubjectMajor SubjectMajor;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Classsection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Schedule> Schedule;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Classsection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<ClasssectionStudent> ClasssectionStudent;
}
