package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Studyweek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StudyweekID;
    private int StudyweekNumber;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Studyweek", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Schedule> Schedule;
}
