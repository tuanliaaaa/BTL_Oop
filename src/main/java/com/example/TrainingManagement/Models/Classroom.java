package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClassroomID;
    private String ClassroomName;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "BuildingID", nullable = false)
    private Building Building;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Classroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Schedule> Schedule;
}
