package com.laptrinhweb.Education.Dto;

public class MarkPostDto {
    private double fifteenMinutes;
    private double fortyFiveMinutes;
    private double semesterMark;
    private int studentId;
    private int subjectId;
    private int semesterId;

    public MarkPostDto() {
    }

    public MarkPostDto(double fifteenMinutes, double fortyFiveMinutes, double semesterMark, int studentId, int subjectId, int semesterId) {
        this.fifteenMinutes = fifteenMinutes;
        this.fortyFiveMinutes = fortyFiveMinutes;
        this.semesterMark = semesterMark;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.semesterId = semesterId;
    }

    public double getFifteenMinutes() {
        return fifteenMinutes;
    }

    public void setFifteenMinutes(double fifteenMinutes) {
        this.fifteenMinutes = fifteenMinutes;
    }

    public double getFortyFiveMinutes() {
        return fortyFiveMinutes;
    }

    public void setFortyFiveMinutes(double fortyFiveMinutes) {
        this.fortyFiveMinutes = fortyFiveMinutes;
    }

    public double getSemesterMark() {
        return semesterMark;
    }

    public void setSemesterMark(double semesterMark) {
        this.semesterMark = semesterMark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
