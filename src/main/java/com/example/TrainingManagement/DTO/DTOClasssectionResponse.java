package com.example.TrainingManagement.DTO;

public class DTOClasssectionResponse {
    private Long ClasssectionId;
    private String subjectCode;
    private String SubjectName;
    private int QuantityReal;
    private int Quantity;
    private String Teacher;
    private String LessonCalender;

    public DTOClasssectionResponse(Long classsectionId, String subjectCode, String subjectName, int quantityReal, int quantity, String teacher, String lessonCalender) {
        ClasssectionId = classsectionId;
        this.subjectCode = subjectCode;
        SubjectName = subjectName;
        QuantityReal = quantityReal;
        Quantity = quantity;
        Teacher = teacher;
        LessonCalender = lessonCalender;
    }

    public Long getClasssectionId() {
        return ClasssectionId;
    }

    public void setClasssectionId(Long classsectionId) {
        ClasssectionId = classsectionId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public int getQuantityReal() {
        return QuantityReal;
    }

    public void setQuantityReal(int quantityReal) {
        QuantityReal = quantityReal;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getLessonCalender() {
        return LessonCalender;
    }

    public void setLessonCalender(String lessonCalender) {
        LessonCalender = lessonCalender;
    }
}
