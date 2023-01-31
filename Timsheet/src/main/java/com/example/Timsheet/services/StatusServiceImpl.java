package com.example.Timsheet.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.RequestDTO;
import com.example.Timsheet.DTO.StateDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.Status;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.repositories.StatusRepository;
import com.example.Timsheet.repositories.UserRepository;

@Service
public class StatusServiceImpl implements StatusService{
    
    @Autowired
    private StatusRepository statusRepository;

     @Autowired
    private UserRepository userRepository;

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
   

    @Override
    public Status getById(Integer id) {
        return statusRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Status tidak ditemukan"));
    }

    @Override
    public boolean save(StatusDTO dto) {
        Employee employee = new Employee();
        Timesheet timesheet = new Timesheet(); 
        Status status = new Status();
        
        employee.setId(dto.getEmployee());
        status.setEmployee(employee);
        timesheet.setId(dto.getTimesheet());
        status.setTimesheet(timesheet);
        status.setName(dto.getName());
        status.setDate(dto.getDate());

        statusRepository.save(status);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        statusRepository.deleteById(id);
        return !statusRepository.findById(id).isPresent();
    }

     
    @Override
    public boolean approval(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Approved Manager");
        status.setDate(new Date());
        // di save
         statusRepository.save(status);
        return true;
    }

    @Override
    public boolean approvalPmo(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Approved PMO");
        status.setDate(new Date());
        // di save
         statusRepository.save(status);
        return true;
    }

    @Override
    public boolean approvalhr(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Approved");
        status.setDate(new Date());
        // di save
         statusRepository.save(status);
        return true;
    }

    
    @Override
    public boolean reject(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Rejected");
        status.setDate(new Date());
        // di save
        statusRepository.save(status);
        return true;
    }



    @Override
    public List<Status> getAllHistoryUser() {
       
        // get current user login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        
         List<Status> tutorials = statusRepository.findHistoryUser(userRepository.findIdByEmail(email));
        return tutorials;
    }

    @Override
    public List<StateDTO> getAllHistoryUserDTO() {
         // get current user login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        List<Status> status = statusRepository.findHistoryUser(userRepository.findIdByEmail(email));
        return status.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public StateDTO convertToDto(Status status){
        return new StateDTO(status.getId(), 
        status.getEmployee().getName(),
        status.getDate(),
        status.getTimesheet().getProjectName(),
        status.getName()
        );
    }

    public List<RequestDTO> requestDTO() {
        List<Status> status = statusRepository.requestDTO();
        return status.stream().map(this::convertToDtoRequest).collect(Collectors.toList());
    }

       public RequestDTO convertToDtoRequest(Status status){
        return new RequestDTO(
            status.getId(),
            status.getTimesheet().getProjectName(),
            status.getName(),
            status.getTimesheet().getRemarks(),
            status.getDate(),
            status.getEmployee().getName(),
            status.getTimesheet().getId()
          
        );
    }
}
