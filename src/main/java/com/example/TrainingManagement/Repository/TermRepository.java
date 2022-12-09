package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;


@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
    public default Term GetTermNowByCredit(){
        ArrayList<Term> list = (ArrayList<Term>) this.findAll();
        ArrayList<Term> termnnow = new ArrayList<>();
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        list.forEach(term -> {
            if(term.getStartTimeSignCredit().before(now)&&term.getEndTimeSignCredit().after(now)){
                termnnow.add(term);
            }
        });
        return  termnnow.get(0);
    }
    public default Term GetTermNearCredit(){
        ArrayList<Term> list = (ArrayList<Term>) this.findAll();
        ArrayList<Term> termnnow = new ArrayList<>();
        final Timestamp[] max = {list.get(0).getEndTimeSignSubject()};
        termnnow.add(list.get(0));
        list.forEach(term -> {
            if(term.getEndTimeSignCredit().after(max[0])){
                max[0] =term.getEndTimeSignCredit();
                termnnow.set(0,term);
            }

        });
        return  termnnow.get(0);
    }
    public default Term GetTermNowBySubject(){
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
    public default Term GetTermNearSubject(){
        ArrayList<Term> list = (ArrayList<Term>) this.findAll();
        ArrayList<Term> termnnow = new ArrayList<>();
        final Timestamp[] max = {list.get(0).getEndTimeSignSubject()};
        termnnow.add(list.get(0));
        list.forEach(term -> {
            if(term.getEndTimeSignSubject().after(max[0])){
                max[0] =term.getEndTimeSignCredit();
                termnnow.set(0,term);
            }

        });
        return  termnnow.get(0);
    }
}