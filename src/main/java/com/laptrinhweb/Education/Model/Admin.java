package com.laptrinhweb.Education.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
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
    private String username;
    private String password;
    @Lob
    @Column(name = "avatar", columnDefinition = "LONGBLOB")
    private byte [] avatar;
    // Cac mapping
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "admins_roles",
            joinColumns = @JoinColumn(name = "admin_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
