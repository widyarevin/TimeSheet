package com.example.Timsheet.services;

import java.util.List;
import com.example.Timsheet.DTO.LoginDTO;
import com.example.Timsheet.DTO.RegisterDTO;
import com.example.Timsheet.models.User;

public interface UserService {
    public List<User> getAll();
    public User getById(Integer id);
    boolean save(RegisterDTO dto);
    public boolean delete(Integer id);
    public boolean LoginEmp(LoginDTO dto);
     public Integer getIdByEmail(String email);
}
