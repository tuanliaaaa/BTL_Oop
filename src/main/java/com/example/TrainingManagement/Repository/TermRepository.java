package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
    public default Term GetTermNow(){
        ArrayList<Term> list = (ArrayList<Term>) this.findAll();
        ArrayList<Term> termnnow = new ArrayList<>();
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        list.forEach(term -> {
            if(term.getStartTimeSignSubject().before(now)&&term.getEndTimeSignSubject().after(now)){
                termnnow.add(term);
            }
        });
        return  termnnow.get(0);
    }
}