package com.example.Timsheet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.DesignationDTO;
import com.example.Timsheet.models.Designation;
import com.example.Timsheet.repositories.DesignationRepository;

@Service
public class DesignatinServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

  
    @Override
    public List<DesignationDTO> getAll() {
        List<Designation> employeeTimesheets = designationRepository.getDesignation();
        return employeeTimesheets.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public DesignationDTO convertToDto(Designation designation){
        return new DesignationDTO(designation.getId(), 
           designation.getName());
    }
    

}
