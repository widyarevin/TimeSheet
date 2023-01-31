package com.example.Timsheet.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.ProjectMountDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.Status;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.repositories.StatusRepository;
import com.example.Timsheet.repositories.TimesheetRepository;
import com.example.Timsheet.repositories.UserRepository;

@Service
public class TimesheetServiceImpl implements TimesheetService{

    @Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Timesheet> getAll() {
        return timesheetRepository.findAll();
    }

    @Override
    public Timesheet getById(Integer id) {
        return timesheetRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Timesheet tidak ditemukan"));
    }

    // @Override
    // public boolean save(Timesheet timesheet) {
    //     Status status = new Status();
    //     Employee employee = new Employee();

    //     // get current user login
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     String email = auth.getName();

    //     employee.setId(userRepository.findIdByEmail(email));
    //     timesheetRepository.save(timesheet);
    //     status.setTimesheet(timesheet);
    //     status.setName("Request");
    //     status.setDate(new Date());
    //     status.setEmployee(employee);
    //     statusRepository.save(status);
    //     return true;
    // }
    
    @Override
    public boolean save(ProjectMountDTO timesheetDTO) {
        Status status = new Status();
        Employee employee = new Employee();
        Timesheet timesheet = new Timesheet();

        employee.setId(timesheetDTO.getEmployee_id());
        timesheet.setProject_Name(timesheetDTO.getProject_Name());
        timesheet.setRemarks(timesheetDTO.getRemarks());
        timesheetRepository.save(timesheet);
        status.setTimesheet(timesheet);
        status.setName("Request");
        status.setDate(new Date());
        status.setEmployee(employee);
        statusRepository.save(status);
        return true;
    }
    
    @Override
    public boolean delete(Integer id) {
        timesheetRepository.deleteById(id);
        return !timesheetRepository.findById(id).isPresent();
    }

    @Override
    public int getByIdTs() {
        return timesheetRepository.findMaxId();
    }
}
