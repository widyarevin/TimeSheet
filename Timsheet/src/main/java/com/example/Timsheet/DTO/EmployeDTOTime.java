package com.example.Timsheet.DTO;

import java.util.Date;

public class EmployeDTOTime {
    public EmployeDTOTime(Integer id, Date work_Date, String activity, String start_Hour, String end_Hour, Integer employee, Integer timesheet) {
        Id = id;
        Work_Date = work_Date;
        Activity = activity;
        Start_Hour = start_Hour;
        End_Hour = end_Hour;
        Employee = employee;
        Timesheet = timesheet;
    }

    private Integer Id;
    private Date Work_Date;
    private String Activity;
    private String Start_Hour;
    private String End_Hour;
    private Integer Employee;
    private Integer Timesheet;

    public Integer getTimesheet() {
        return Timesheet;
    }
    public void setTimesheet(Integer timesheet) {
        Timesheet = timesheet;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public Date getWork_Date() {
        return Work_Date;
    }
    public void setWork_Date(Date work_Date) {
        Work_Date = work_Date;
    }
    public String getActivity() {
        return Activity;
    }
    public void setActivity(String activity) {
        Activity = activity;
    }
    public String getStart_Hour() {
        return Start_Hour;
    }
    public void setStart_Hour(String start_Hour) {
        Start_Hour = start_Hour;
    }
    public String getEnd_Hour() {
        return End_Hour;
    }
    public void setEnd_Hour(String end_Hour) {
        End_Hour = end_Hour;
    }
    public Integer getEmployee() {
        return Employee;
    }
    public void setEmployee(Integer employee) {
        Employee = employee;
    }
}