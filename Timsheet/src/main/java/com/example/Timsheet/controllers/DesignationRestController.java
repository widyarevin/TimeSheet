package com.example.Timsheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.DTO.DesignationDTO;
import com.example.Timsheet.services.DesignationService;

@RestController
@RequestMapping("/api/designation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DesignationRestController {
    
private DesignationService designationService;

    @Autowired
    public DesignationRestController(DesignationService designationService){
        this.designationService = designationService;
    }

    @GetMapping
    public List<DesignationDTO> getAll(){
        return designationService.getAll();
    }

}
