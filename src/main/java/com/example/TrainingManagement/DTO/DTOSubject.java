package com.example.TrainingManagement.DTO;

public class DTOSubject {
    String subjectCode;
    public DTOSubject() {

    }

    public DTOSubject(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
