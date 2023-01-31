package com.example.Timsheet.DTO;

import java.util.Date;

public class StatusDTO {
    private String Name;
    private Date Date;
    private Integer Employee;
    private Integer Timesheet;

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
    public Integer getEmployee() {
        return Employee;
    }
    public void setEmployee(Integer employee) {
        Employee = employee;
    }
    public Integer getTimesheet() {
        return Timesheet;
    }
    public void setTimesheet(Integer timesheet) {
        Timesheet = timesheet;
    }
}
