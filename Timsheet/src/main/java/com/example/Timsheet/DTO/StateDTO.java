package com.example.Timsheet.DTO;

import java.util.Date;

public class StateDTO {
     public StateDTO(Integer id, String name,  Date date, String project_name, String status
     ) {
        Id = id;
        Name = name;
        Date = date;
        Project_name= project_name;
        Status = status;
    }

    private Integer Id;
    private String Name;
    private Date Date;
    private String Project_name;
    private String Status;

    
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Date getDate() {
        return Date;
    }
    public void setDate(Date date) {
        Date = date;
    }
    public String getProject_name() {
        return Project_name;
    }
    public void setProject_name(String project_name) {
        Project_name = project_name;
    }

}
