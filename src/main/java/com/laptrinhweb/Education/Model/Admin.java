package com.laptrinhweb.Education.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idAdmin", unique = true)
    private String idAdmin;
    @Column(name = "fullName")
    @NotEmpty
    private String fullName;
    @Column(name = "birthDay")
    private String birthDay;
    @Column(name = "gender")
    @NotEmpty
    private String gender;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "phone")
    @NotEmpty
    private String phone;
    @Column(name = "address")
    @NotEmpty
    private String address;
    @Column(name = "workDay")
    @NotEmpty
    private String workDay;
    @Lob
    @Column(name = "avatar", columnDefinition = "LONGBLOB")
    private byte [] avatar;
    // Cac mapping
    @OneToOne(mappedBy = "admin", cascade =  CascadeType.ALL)
    private Account account;
    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public @NotEmpty String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public @NotEmpty String getGender() {
        return gender;
    }

    public void setGender(@NotEmpty String gender) {
        this.gender = gender;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotEmpty String getPhone() {
        return phone;
    }

    public void setPhone(@NotEmpty String phone) {
        this.phone = phone;
    }

    public @NotEmpty String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty String address) {
        this.address = address;
    }

    public @NotEmpty String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(@NotEmpty String workDay) {
        this.workDay = workDay;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
