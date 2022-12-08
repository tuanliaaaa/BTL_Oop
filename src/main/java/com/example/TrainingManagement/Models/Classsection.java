package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "TeacherID", nullable = false)
    private Teacher Teacher;
    @ManyToOne
    @JoinColumn(name = "TermID", nullable = false)
    private Term Term;
    @ManyToOne
    @JoinColumn(name = "SubjectMajorID", nullable = false)
    private SubjectMajor SubjectMajor;
    @JsonBackReference
    @OneToMany(mappedBy = "Classsection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Schedule> Schedule;
    @JsonBackReference
    @OneToMany(mappedBy = "Classsection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<ClasssectionStudent> ClasssectionStudent;
}
