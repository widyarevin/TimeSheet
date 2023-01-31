package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.models.Department;
import com.example.Timsheet.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentRestController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<Department> getAll(){
        return departmentService.getAll();
    }

}
