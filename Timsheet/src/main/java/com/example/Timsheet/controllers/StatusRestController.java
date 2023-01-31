package com.example.Timsheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Timsheet.DTO.RequestDTO;
import com.example.Timsheet.DTO.StateDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;
import com.example.Timsheet.services.StatusService;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatusRestController {
    @Autowired
    private StatusService statusService;


     @GetMapping
    public List<Status> getAll(){
        return statusService.getAllHistoryUser();
    }
    
    @PostMapping("/insert")
    public Boolean submitStatus(@RequestBody StatusDTO dto){
        Boolean result;
            result = statusService.save(dto);
        return result;
    }

   
    @GetMapping("/history")
    public List<StateDTO> getAllDTO(){
        return statusService.getAllHistoryUserDTO();
    }
    
    @PutMapping("/approve/{id}")
    public Boolean approveMaster(@PathVariable(required = true) Integer id){
        Boolean result;
        result =  statusService.approval(id);
        return result;
    }

    @PutMapping("/approvePmo/{id}")
    public Boolean approveMasterPmo(@PathVariable(required = true) Integer id){
        Boolean result;
        result =  statusService.approvalPmo(id);
        return result;
    }

    @PutMapping("/approveHr/{id}")
    public Boolean approveMasterHr(@PathVariable(required = true) Integer id){
        Boolean result;
        result =  statusService.approvalhr(id);
        return result;
    }

    @PutMapping("/reject/{id}")
    public Boolean rejectMaster(@PathVariable(required = true) Integer id){
        Boolean result;
     result =   statusService.reject(id);
        return result;
    }

    @GetMapping("/getrequest")
    public List<RequestDTO> getAllReq(){
        return statusService.requestDTO();
    }

    
}
