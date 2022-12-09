package com.example.TrainingManagement.DTO;

public class DTOSubjectAndMajorResponse {
    private Long SubjectID;
    private String SubjectCode;
    private String SubjectName;
    private  Long SubjectMajorID;

    public DTOSubjectAndMajorResponse() {
    }

    public DTOSubjectAndMajorResponse(Long subjectID, String subjectCode, String subjectName, Long subjectMajorID) {
        SubjectID = subjectID;
        SubjectCode = subjectCode;
        SubjectName = subjectName;
        SubjectMajorID = subjectMajorID;
    }

    public Long getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Long subjectID) {
        SubjectID = subjectID;
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

    public Long getSubjectMajorID() {
        return SubjectMajorID;
    }

    public void setSubjectMajorID(Long subjectMajorID) {
        SubjectMajorID = subjectMajorID;
    }
}
