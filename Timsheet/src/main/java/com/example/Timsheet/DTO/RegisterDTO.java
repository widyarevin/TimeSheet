package com.example.Timsheet.DTO;

import java.util.Date;

public class RegisterDTO {
    private String Nik;
    private String Name;
    private String Email;
    private Date BirthDate;
    private String Password;
    private Integer Designation;

    public String getNik() {
        return Nik;
    }
    public void setNik(String nik) {
        Nik = nik;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public Date getBirthdate() {
        return BirthDate;
    }
    public void setBirthdate(Date birthdate) {
        this.BirthDate = birthdate;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public Integer getDesignation() {
        return Designation;
    }
    public void setDesignation(Integer designation) {
        Designation = designation;
    }
    
}
