package com.example.Timsheet.DTO;

public class ProjectMountDTO {
    private String project_Name;
    private String remarks;
    private Integer employee_id;
    public String getProject_Name() {
        return project_Name;
    }
    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Integer getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
}
