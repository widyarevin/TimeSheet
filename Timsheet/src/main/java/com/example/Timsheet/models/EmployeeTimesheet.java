package com.example.Timsheet.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tbl_tr_employee_timesheet")
public class EmployeeTimesheet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Work_Date;

    @Column(name = "activity")
    private String Activity;

    @Column(name = "start_hour")
    private String Start_Hour;

    @Column(name = "end_hour")
    private String End_Hour;

    @Column(name = "presents")
    private String Presents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timesheet_id")
    private Timesheet Timesheet;


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
    public String getPresents() {
        return Presents;
    }
    public void setPresents(String presents) {
        Presents = presents;
    }
    public Employee getEmployee() {
        return Employee;
    }
    public void setEmployee(Employee employee) {
        Employee = employee;
    }
    public Timesheet getTimesheet() {
        return Timesheet;
    }
    public void setTimesheet(Timesheet timesheet) {
        Timesheet = timesheet;
    }
}
