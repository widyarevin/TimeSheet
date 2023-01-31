package com.example.Timsheet.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "tbl_m_employee")
public class Employee {
    
    @Id
    @Column(name = "id")
    private Integer Id;

    @Column(name = "nik")
    private String Nik;

    @Column(name = "name")
    private String Name;

    @Column(name = "email", unique = true)
    private String Email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date BirthDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id")
    private Designation Designation;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "client_id")
    // private Client client;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
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
        Email = email;
    }
    public Date getBirthdate() {
        return BirthDate;
    }
    public void setBirthdate(Date birthdate) {
        this.BirthDate = birthdate;
    }
    public Designation getDesignation() {
        return Designation;
    }
    public void setDesignation(Designation designation) {
        Designation = designation;
    }

    // public Client getClient() {
    //     return client;
    // }
    // public void setClient(Client client) {
    //     this.client = client;
    // }

}
