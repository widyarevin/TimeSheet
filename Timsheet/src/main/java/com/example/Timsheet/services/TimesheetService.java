package com.example.Timsheet.services;

import java.util.List;

import com.example.Timsheet.DTO.ProjectMountDTO;
import com.example.Timsheet.models.Timesheet;

public interface TimesheetService {
    public List<Timesheet> getAll();
    public Timesheet getById(Integer id);
    // public boolean save(Timesheet timesheet);
    public boolean save(ProjectMountDTO timesheet);
    public boolean delete(Integer id);
    public int getByIdTs();
    
}

