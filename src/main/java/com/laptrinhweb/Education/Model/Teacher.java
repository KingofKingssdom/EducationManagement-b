package com.laptrinhweb.Education.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Id_Teacher", unique = true)
    private String idTeacher;
    @Column(name = "fullName")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String fullName;
    @Column(name = "birthDay")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String birthDay;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String phone;
    @Column(name = "email")
    @Email(message = "Phai dung dinh dang @gmail.com")
    private String email;
    @Column(name = "classroom")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String classroom;
    @Column(name = "address")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String address;
    @Column(name = "workDay")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String workDay;
    @Column(name = "subject")
    @NotEmpty(message = "Dữ liệu không được để trống")
    private String subject;
    @Lob
    @Column(name = "avatar", columnDefinition = "LONGBLOB")
    private byte [] avatar;
    public Teacher() {
    }

    public String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(String workDay) {
        this.workDay = workDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public @NotEmpty(message = "Dữ liệu không được để trống") String getSubject() {
        return subject;
    }

    public void setSubject(@NotEmpty(message = "Dữ liệu không được để trống") String subject) {
        this.subject = subject;
    }
}
