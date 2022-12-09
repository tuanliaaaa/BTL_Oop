package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Studytime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StudentID;
    private int StudytimeNumber;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Studytime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Schedule> Schedule;
}
