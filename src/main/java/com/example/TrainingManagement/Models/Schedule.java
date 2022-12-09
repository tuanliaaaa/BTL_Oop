package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ScheduleID;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ClassroomID", nullable = false)
    private Classroom Classroom;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ClasssectionID", nullable = false)
    private Classsection Classsection;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudytimeID", nullable = false)
    private Studytime Studytime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudyweekID", nullable = false)
    private Studyweek Studyweek;
}
