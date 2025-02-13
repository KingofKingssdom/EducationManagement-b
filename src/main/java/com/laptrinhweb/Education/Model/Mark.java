package com.laptrinhweb.Education.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fifteenMinutesTest")
    private double fifteenMinutes;
    @Column(name = "fortyFiveMinutesTest")
    private double fortyFiveMinutes;
    @Column(name = "semesterTest")
    private double semesterMark;
    // Các ánh xạ
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;
    public Mark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
