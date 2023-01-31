package com.example.Timsheet.DTO;

import java.util.Date;

public class RequestDTO {
    
    private Integer Id;
    private String Project_name;
    private String Status_name;
    private String Remarks;
    private Date Date;
    private String Employee_name;
    private Integer Id_timesheet;

    


    public RequestDTO(Integer id, String project_name, String status_name, String remarks, java.util.Date date,
            String employee_name, Integer id_timesheet) {
        Id = id;
        Project_name = project_name;
        Status_name = status_name;
        Remarks = remarks;
        Date = date;
        Employee_name = employee_name;
        Id_timesheet = id_timesheet;
    }

    
    public Integer getId_timesheet() {
        return Id_timesheet;
    }


    public void setId_timesheet(Integer id_timesheet) {
        Id_timesheet = id_timesheet;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getProject_name() {
        return Project_name;
    }
    public void setProject_name(String project_name) {
        Project_name = project_name;
    }
    public String getStatus_name() {
        return Status_name;
    }
    public void setStatus_name(String status_name) {
        Status_name = status_name;
    }
    public String getRemarks() {
        return Remarks;
    }
    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
    public Date getDate() {
        return Date;
    }
    public void setDate(Date date) {
        Date = date;
    }
    public String getEmployee_name() {
        return Employee_name;
    }
    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

}
