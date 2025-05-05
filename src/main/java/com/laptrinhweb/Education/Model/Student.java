package com.laptrinhweb.Education.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idStudent", unique = true)
    private String idStudent;
    @Column(name = "fullName")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String fullName;
    @Column(name = "birth")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String birth;
    @Column(name = "gender")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String gender;
    @Column(name = "email")
    @Email(message = "Phải để định dạng @gmail.com")
    private String email;
    @Column(name = "phone")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String phone;
    @Column(name = "address")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String address;
    @Column(name = "studyDay")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String studyDay;
    @Column(name = "classroom")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String classroom;
    @Lob
    @Column(name = "avatar")
    private byte [] avatar;

    // Các ánh xạ
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mark> marks;
    public Student() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public  String getFullName() {
        return fullName;
    }

    public void setFullName( String fullName) {
        this.fullName = fullName;
    }

    public  String getBirth() {
        return birth;
    }

    public void setBirth( String birth) {
        this.birth = birth;
    }

    public  String getGender() {
        return gender;
    }

    public void setGender( String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public  String getPhone() {
        return phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
    }

    public  String getStudyDay() {
        return studyDay;
    }

    public void setStudyDay( String studyDay) {
        this.studyDay = studyDay;
    }

    public  String getClassroom() {
        return classroom;
    }

    public void setClassroom( String classroom) {
        this.classroom = classroom;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
