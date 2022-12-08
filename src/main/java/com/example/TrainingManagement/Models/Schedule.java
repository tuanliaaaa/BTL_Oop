package com.example.TrainingManagement.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ScheduleID;
    @ManyToOne
    @JoinColumn(name = "ClassroomID", nullable = false)
    private Classroom Classroom;
    @ManyToOne
    @JoinColumn(name = "ClasssectionID", nullable = false)
    private Classsection Classsection;
    @ManyToOne
    @JoinColumn(name = "StudytimeID", nullable = false)
    private Studytime Studytime;
    @ManyToOne
    @JoinColumn(name = "StudyweekID", nullable = false)
    private Studyweek Studyweek;
}
