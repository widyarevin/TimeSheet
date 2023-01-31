package com.example.Timsheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Timsheet.DTO.ProjectMountDTO;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.services.TimesheetService;

@RestController
@RequestMapping("/api/timesheet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TimesheetRestController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping
    public List<Timesheet> getAll(){
        return timesheetService.getAll();
    }

    // @PostMapping("/insert")
    // public Boolean insert(@RequestBody Timesheet timesheet) {
    //     Boolean result = timesheetService.save(timesheet);
    //     return result;
    // }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody ProjectMountDTO timesheet) {
        Boolean result = timesheetService.save(timesheet);
        return result;
    }

}
