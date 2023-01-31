package com.example.Timsheet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tbl_m_timesheet")
public class Timesheet {

    @Id 
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "project_name")
    private String ProjectName;

    @Column(name = "remarks")
    private String Remarks;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getProjectName() {
        return ProjectName;
    }
    public void setProject_Name(String projectName) {
        ProjectName = projectName;
    }
    public String getRemarks() {
        return Remarks;
    }
    public void setRemarks(String remarks) {
        Remarks = remarks;
    }


}
