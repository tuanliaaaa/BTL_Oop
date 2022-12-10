package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    public default List<Schedule> findByClasssrction(Classsection classsection){
        ArrayList<Schedule> list = (ArrayList<Schedule>) this.findAll();
        ArrayList<Schedule> schedules = new ArrayList<>();
        list.forEach(schedule -> {
            if(schedule.getClasssection().equals(classsection)){
                schedules.add(schedule);
            }
        });
        return  schedules;
    }
    public default List<Schedule> findByStudytime(String studytime){
        ArrayList<Schedule> list = (ArrayList<Schedule>) this.findAll();
        ArrayList<Schedule> schedules = new ArrayList<>();
        list.forEach(schedule -> {
            if(schedule.getStudytime().equals(studytime)){
                schedules.add(schedule);
            }
        });
        return  schedules;
    }
}
