package com.example.TrainingManagement.DTO;

public class DTOClasssectioinStudentResponse {
    private  Long id;
    private Long classSection;
    private String SubjectCode;
    private String SubjectName;

    public DTOClasssectioinStudentResponse(Long id, Long classSection, String subjectCode, String subjectName) {
        this.id = id;
        this.classSection = classSection;
        SubjectCode = subjectCode;
        SubjectName = subjectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassSection() {
        return classSection;
    }

    public void setClassSection(Long classSection) {
        this.classSection = classSection;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }
}
