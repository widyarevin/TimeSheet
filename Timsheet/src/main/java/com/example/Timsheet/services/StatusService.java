package com.example.Timsheet.services;

import java.util.List;

import com.example.Timsheet.DTO.RequestDTO;
import com.example.Timsheet.DTO.StateDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;

public interface StatusService {
    public List<Status> getAll();
    public Status getById(Integer id);
    public boolean save(StatusDTO dto);
    public boolean delete(Integer id);
    public boolean approval(int id);
      public boolean approvalPmo(int id);
       public boolean approvalhr(int id);
    public boolean reject(int id);
    public List<Status> getAllHistoryUser();
    public List<StateDTO> getAllHistoryUserDTO();
    public List<RequestDTO> requestDTO();
}
