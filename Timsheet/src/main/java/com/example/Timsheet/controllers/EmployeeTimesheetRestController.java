package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.services.EmployeeTimesheetService;
import com.example.Timsheet.DTO.EmployeDTOTime;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.EmployeeTimesheet;

@RestController
@RequestMapping("/api/emptime")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeTimesheetRestController {

    @Autowired
    private EmployeeTimesheetService employeeTimesheetService;

    @GetMapping
    public List<EmployeeTimesheet> getAll(){
        return employeeTimesheetService.getAll();
    }


    @GetMapping("/emptmdto")
    public List<EmployeDTOTime> getAllDTO(){
        return employeeTimesheetService.getEmployeeTimesheetDTO();
    }

    @PostMapping("/insert")
    public Boolean submitRegisterasi(@RequestBody EmployeeTimesheetDTO dto){
        Boolean result;
            result = employeeTimesheetService.save(dto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable(required = true) Integer id) {
        Boolean result = employeeTimesheetService.delete(id);
        return result;
    }

     @GetMapping("/getDetail/{id}")
    public List<EmployeDTOTime> getAllReq(@PathVariable(required = true) int id){
        return employeeTimesheetService.getDetailTimeshet(id);
    }

}
