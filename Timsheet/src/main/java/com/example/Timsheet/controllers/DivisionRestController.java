package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.models.Division;
import com.example.Timsheet.services.DivisionService;

@RestController
@RequestMapping("/api/division")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DivisionRestController {
    
       private DivisionService divisionService;

    @Autowired
    public DivisionRestController(DivisionService divisionService){
        this.divisionService = divisionService;
    }

    @GetMapping
    public List<Division> getAll(){
        return divisionService.getAll();
    }
}
