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
    private String Classroom;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ClasssectionID", nullable = false)
    private Classsection Classsection;

    private String Studytime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudyweekID", nullable = false)
    private Studyweek Studyweek;
    private int LessonNumber;
}
